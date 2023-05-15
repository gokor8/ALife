package com.alife.anotherlife.ui.screen.main.create_alife

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
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.LCEErrorCamera
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BasePictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.PictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.BaseVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.BaseCreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.BaseCreateAlifeVideoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import kotlinx.coroutines.CoroutineScope
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
        if (captureWrapper is CookedCaptureWrapper)
            createAlifePhotoReducer.onCaptureWrapper(captureWrapper)
        else
            setState { copy(lceModel = LCEErrorCamera()) }
    }

    override suspend fun onVideoWrapper(captureWrapper: BaseVideoCaptureWrapper) {
        createAlifeVideoReducer.onVideoPrepare(captureWrapper)
    }

    override suspend fun onPictureLoading() {
        createAlifePhotoReducer.onPictureLoading()
    }

    override suspend fun onVideoLoading() {
        createAlifeVideoReducer.onVideoLoading()
    }

    override suspend fun onCreatePhoto(
        viewModelScope: CoroutineScope,
        contextWrapper: BaseContextMainExecutorWrapper,
        captureWrapper: CookedCaptureWrapper
    ) {
        val screenState = getState().pagerContainer.picture.screenState

        if (screenState is PictureScreenState)
            createAlifePhotoReducer.onCreatePhoto(
                viewModelScope,
                screenState,
                captureWrapper,
                contextWrapper
            )
    }


    override suspend fun onStartVideo(
        contextMainExecutorWrapper: BaseContextMainExecutorWrapper,
        videoCapture: BaseStartVideoCaptureState
    ) {
        createAlifeVideoReducer.onStart(contextMainExecutorWrapper, videoCapture)
    }

    override suspend fun onRecordingAction(
        captureState: RecordingCaptureState,
        recordingAction: RecordingAction
    ) {
        createAlifeVideoReducer.onRecordingAction(captureState, recordingAction)
    }

    override suspend fun onPicturePermission(
        photoPermission: CreateAlifeAction.PhotoPermission,
        screenState: BasePictureScreenState
    ) {
        photoPermission.onPermission(createAlifePhotoReducer, screenState)
    }

    override suspend fun onVideoPermission(
        videoPermission: CreateAlifeAction.VideoPermission,
        screenState: BaseVideoScreenState
    ) {
        videoPermission.onPermission(createAlifeVideoReducer, screenState)
    }

    override suspend fun onClickSmallVideo() {
        if (getState().canPagerItemScroll())
            createAlifeVideoReducer.onClickSmallVideo()
    }

    override suspend fun onAudioPermission(permissionStatus: PermissionStatus) {
        createAlifeVideoReducer.onAudioPermission(permissionStatus)
    }
}