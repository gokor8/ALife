package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
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
    override suspend fun onCameraWrapper(captureWrapper: BaseCaptureWrapper) {
        setState { copy(captureWrapper = captureWrapper) }
    }

    override suspend fun onPictureCameraPermission(
        photoCameraPermission: CreateAlifeAction.PhotoCameraPermission
    ) { photoCameraPermission.onPermission(createAlifePhotoReducer) }

    override suspend fun onVideoCameraPermission(
        videoCameraPermission: CreateAlifeAction.VideoCameraPermission
    ) { videoCameraPermission.onPermission(createAlifeVideoReducer) }

    override suspend fun onCreatePhoto(contextWrapper: BaseContextMainExecutorWrapper) {
        createAlifePhotoReducer.onCreatePhoto(contextWrapper)
    }

    override suspend fun onClickSmallVideo() {
        createAlifeVideoReducer.onClickSmallVideo()
    }

    override suspend fun onAudioPermission(permissionStatus: PermissionStatus) {
        createAlifeVideoReducer.onAudioPermission(permissionStatus)
    }

//    override suspend fun onAudioPermission(permissionStatus: PermissionStatus) {
//        if(permissionStatus !is PermissionStatus.Success) return
//
//        setState {
//            copy(
//                screenState = VideoCameraScreenState(),
//                isAudioEnabled = permissionStatus is PermissionStatus.Success,
//            )
//        }
//    }
}