package com.alife.anotherlife.ui.screen.main.create_alife

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageProxy
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.CameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ErrorScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.domain.main.create_alife.CreateFirstAlifeUseCase
import com.alife.domain.main.create_alife.entity.SaveFirstImageEntity
import javax.inject.Inject

class CreateAlifeReducer @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>,
    val createFirstAlifeUseCase: CreateFirstAlifeUseCase
) : BaseVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCreateAlifeReducer {

    override suspend fun onChangeCamera() {
        setState {
            val currentSelector = (screenState as? CameraScreenState)?.inverseCameraSelector()
                ?: CameraSelector.DEFAULT_FRONT_CAMERA

            copy(screenState = CameraScreenState(currentSelector))
        }
    }

    override suspend fun onCameraWrapper(captureWrapper: BaseCaptureWrapper) {
        setState { copy( captureWrapper = captureWrapper) }
    }

    override suspend fun onTakePhoto(imageProxy: ImageProxy) {
        Log.d("OnTakePhoto", "Take Photo")

        createFirstAlifeUseCase.saveImage(
            SaveFirstImageEntity(imageProxy.planes[0].buffer.array())
        )
    }

    override suspend fun onPermissionGranted() {
        setState { copy(screenState = CameraScreenState()) }
    }

    override suspend fun onPermissionFatal() {
        setState { copy(screenState = ErrorScreenState()) }
    }
}