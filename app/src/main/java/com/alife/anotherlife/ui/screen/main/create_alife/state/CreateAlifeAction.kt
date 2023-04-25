package com.alife.anotherlife.ui.screen.main.create_alife.state

import android.content.ContextWrapper
import androidx.camera.core.ImageProxy
import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.create_alife.BaseCreateAlifeReducer
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
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

    class CreatePhoto(private val contextWrapper: BaseContextMainExecutorWrapper) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducer) {
            reducer.onCreatePhoto(contextWrapper)
        }
    }

    class ClickSmallVideo : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducer) {
            reducer.onClickSmallVideo()
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