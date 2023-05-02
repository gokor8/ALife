package com.alife.anotherlife.ui.screen.main.create_alife.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.BaseCreateAlifeReducerBase
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.BaseCameraPermissionReducer

interface CreateAlifeAction : BaseMVIAction<BaseCreateAlifeReducerBase> {

    class ChangeCameraSelection : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onChangeCamera()
        }
    }

    class OnCaptureWrapper(private val captureWrapper: BaseCaptureWrapper) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onCameraWrapper(captureWrapper)
        }
    }

    class CreatePhoto(private val contextWrapper: BaseContextMainExecutorWrapper) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onCreatePhoto(contextWrapper)
        }
    }

    class ClickSmallVideo : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onClickSmallVideo()
        }
    }

    abstract class CameraPermission(protected val isGranted: Boolean) : CreateAlifeAction {
        suspend fun onPermission(reducer: BaseCameraPermissionReducer) {
            if(isGranted) reducer.onPermissionGranted() else reducer.onPermissionFatal()
        }
    }

    class PhotoCameraPermission(isGranted: Boolean) : CameraPermission(isGranted) {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onPictureCameraPermission(this)
        }
    }

    class VideoCameraPermission(isGranted: Boolean) : CameraPermission(isGranted) {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onVideoCameraPermission(this)
        }
    }

//    class VideoAudioPermission(private val isGranted: Boolean) : CreateAlifeAction {
//        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
//            if(isGranted)
//                reducer.onAudioPermissionGranted()
//            else
//                reducer.onAudioPermissionFatal()
//        }
//    }

    class AudioPermission(private val permissionStatus: PermissionStatus) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onAudioPermission(permissionStatus)
        }
    }
}