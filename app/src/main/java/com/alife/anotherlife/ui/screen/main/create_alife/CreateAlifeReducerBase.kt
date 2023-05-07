package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.video.VideoRecordEvent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.RecordingCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording.RecordingWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.ErrorCameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BaseCameraPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.BaseCreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.BaseCreateAlifeVideoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import javax.inject.Inject

class CreateAlifeReducerBase @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>,
    private val createAlifePhotoReducer: BaseCreateAlifePhotoReducer,
    private val createAlifeVideoReducer: BaseCreateAlifeVideoReducer
) : HandlerBaseVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCreateAlifeReducerBase {

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onChangeCamera() {
        setState { copy(pagerContainer = tryCopyWithInvert()) }
    }

    @OptIn(ExperimentalFoundationApi::class)
    override fun onChangedAudio(isEnabled: Boolean) {
        setState { copy(isAudioEnabled = isEnabled) }
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onCameraWrapper(captureWrapper: BaseCaptureWrapper) {
        setState {
            if (captureWrapper is CookedCaptureWrapper)
                copy(
                    captureWrapper = captureWrapper,
                    pagerContainer = copyCurrentScreenPage(captureWrapper)
                )
            else
                copy(blockingScreen = ErrorCameraScreenState())
        }
    }

    override suspend fun onVideoWrapper(captureWrapper: BaseVideoCaptureWrapper) {
        createAlifeVideoReducer.onVideoPrepare(captureWrapper)
    }

    override suspend fun onCreatePhoto(contextWrapper: BaseContextMainExecutorWrapper) {
        // TODO сделать так же как и видео
        val screenState = getState().currentContainerState().screenState

        if (screenState is BaseCameraPictureScreenState) {
            createAlifePhotoReducer.onCreatePhoto(screenState, contextWrapper)
        }
    }

    override suspend fun onStartVideo(
        contextMainExecutorWrapper: BaseContextMainExecutorWrapper,
        videoCapture: BaseStartVideoCaptureState
    ) {
        createAlifeVideoReducer.onStart(contextMainExecutorWrapper, videoCapture)
    }

    override suspend fun onRecordingAction(
        recordingWrapper: RecordingCaptureState,
        recordingAction: RecordingAction
    ) {
        createAlifeVideoReducer.onRecordingAction(recordingWrapper, recordingAction)
    }

//    override suspend fun onRecordingEvent(recordingAction: VideoRecordEvent) {
//        createAlifeVideoReducer.onRecordingEvent(recordingAction)
//    }

    override suspend fun onPicturePermission(photoPermission: CreateAlifeAction.PhotoPermission) {
        photoPermission.onPermission(createAlifePhotoReducer)
    }

    override suspend fun onVideoPermission(videoPermission: CreateAlifeAction.VideoPermission) {
        videoPermission.onPermission(createAlifeVideoReducer)
    }

    override suspend fun onClickSmallVideo() {
        if (getState().canPagerItemScroll())
            createAlifeVideoReducer.onClickSmallVideo()
    }

    override suspend fun onAudioPermission(permissionStatus: PermissionStatus) {
        createAlifeVideoReducer.onAudioPermission(permissionStatus)
    }
}