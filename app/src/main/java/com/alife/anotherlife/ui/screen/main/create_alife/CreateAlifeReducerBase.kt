package com.alife.anotherlife.ui.screen.main.create_alife

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.ErrorCameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BaseCameraPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.CameraPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.BaseCreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.BaseCreateAlifeVideoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import java.util.concurrent.Executor
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

    override suspend fun onStartVideo(
        contextMainExecutorWrapper: BaseContextMainExecutorWrapper,
        videoCapture: BaseStartVideoCaptureState
    ) {
        createAlifeVideoReducer.onStart(contextMainExecutorWrapper, videoCapture)
    }

    override suspend fun onCreatePhoto(contextWrapper: BaseContextMainExecutorWrapper) {
        val mainExecutor = contextWrapper.getMainExecutor()
        // TODO after me change pagerContainer to list, call getCurrentScreenPager.screenState
        val screenState = getState().currentContainerState().screenState

        if (screenState is BaseCameraPictureScreenState && mainExecutor != null) {
            createAlifePhotoReducer.onCreatePhoto(screenState, mainExecutor)
        }
    }

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