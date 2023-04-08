package com.alife.anotherlife.ui.screen.main.create_alife.state

import androidx.camera.core.ImageProxy
import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.create_alife.BaseCreateAlifeReducer
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper

interface CreateAlifeAction : BaseMVIAction<BaseCreateAlifeReducer> {

    class ChangeCameraSelection : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducer) {
            reducer.onChangeCamera()
        }
    }

    class OnCaptureWrapper(private val captureWrapper: BaseCaptureWrapper) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducer) {
            reducer.onCameraWrapper(captureWrapper)
        }
    }

    class TakePhoto(private val imageProxy: ImageProxy) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducer) {
            // Fix it, fix change camera
            reducer.onTakePhoto(imageProxy.planes[0].buffer.array())
        }
    }

    class PermissionGrantedAction : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducer) {
            reducer.onPermissionGranted()
        }
    }

    class PermissionFatalAction : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducer) {
            reducer.onPermissionFatal()
        }
    }
}