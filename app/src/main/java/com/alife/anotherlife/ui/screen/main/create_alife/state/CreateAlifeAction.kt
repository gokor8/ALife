package com.alife.anotherlife.ui.screen.main.create_alife.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.BaseCreateAlifeReducerBase
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
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

    class CreatePhoto(private val contextWrapper: BaseContextMainExecutorWrapper) :
        CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onCreatePhoto(contextWrapper)
        }
    }

    class ClickSmallVideo : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onClickSmallVideo()
        }
    }

    abstract class CameraPermission(
        private val isGranted: Boolean,
        private val newScreenState: ScreenState
    ) : CreateAlifeAction {
        suspend fun onPermission(reducer: BaseCameraPermissionReducer) {
            if (isGranted)
                reducer.onPermissionGranted(newScreenState)
            else
                reducer.onPermissionFatal()
        }
    }

    class PhotoPermission(
        isGranted: Boolean,
        newScreenState: ScreenState
    ) : CameraPermission(isGranted, newScreenState) {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onPictureCameraPermission(this)
        }
    }

    class VideoPermission(
        isGranted: Boolean,
        newScreenState: ScreenState
    ) : CameraPermission(isGranted, newScreenState) {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onVideoCameraPermission(this)
        }
    }

    class AudioPermission(private val permissionStatus: PermissionStatus) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onAudioPermission(permissionStatus)
        }
    }
}