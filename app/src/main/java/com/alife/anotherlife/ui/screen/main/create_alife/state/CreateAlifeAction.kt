package com.alife.anotherlife.ui.screen.main.create_alife.state

import android.content.ContextWrapper
import androidx.camera.core.ImageProxy
import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.create_alife.BaseCreateAlifeReducer
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.ImageProxyToByteArray
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.ImageProxyToYuvByteArray
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CameraPagerItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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

    class ChangeCameraPagerItem(private val pagerItem: CameraPagerItem) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducer) {
            reducer.onStartTakePhoto(pagerItem)
        }
    }

    class TakePhoto(private val imageProxy: ImageProxy) : CreateAlifeAction {
        @androidx.annotation.OptIn(androidx.camera.core.ExperimentalGetImage::class)
        override suspend fun onAction(reducer: BaseCreateAlifeReducer) {
            // Fix it, fix change camera
            val imageByteArray = withContext(Dispatchers.IO) {
                if (imageProxy.planes.size > 1)
                    ImageProxyToYuvByteArray().map(imageProxy)
                else
                    ImageProxyToByteArray().map(imageProxy)
            }
            reducer.onTakePhoto(imageByteArray)
        }
    }

    class CreatePhoto(private val contextWrapper: ContextWrapper) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducer) {
            reducer.onCreatePhoto(contextWrapper)
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