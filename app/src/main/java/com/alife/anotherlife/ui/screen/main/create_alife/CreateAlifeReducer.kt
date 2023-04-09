package com.alife.anotherlife.ui.screen.main.create_alife

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageProxy
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.BaseCameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.CameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.model.CameraSelectorInverter
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraFirstScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraSecondScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ErrorScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleCamera
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.main.create_alife.BaseSaveAlifeUseCase
import com.alife.domain.main.create_alife.ReadAlifeUseCase
import com.alife.domain.main.create_alife.SaveAlifeUseCase
import com.alife.domain.main.create_alife.entity.SaveImageEntity
import javax.inject.Inject

class CreateAlifeReducer @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>,
    private val cameraStateToSaveImage: BaseCameraStateToSaveImage,
    private val saveAlifeUseCase: BaseSaveAlifeUseCase
) : BaseVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCreateAlifeReducer {

    override suspend fun onChangeCamera() {
        val currentScreenState = getState().screenState
        if (currentScreenState is InvertibleCamera) {
            setState { copy(screenState = currentScreenState.copyInvertCamera()) }
        }
    }

    override suspend fun onCameraWrapper(captureWrapper: BaseCaptureWrapper) {
        setState { copy(captureWrapper = captureWrapper) }
    }

    override suspend fun onTakePhoto(imageByteArray: ByteArray) {
        getStateSuspend {
            if (screenState !is CameraScreenState) return@getStateSuspend

            setState { copy(screenState = LoadScreenState()) }

            val saveImageEntity = cameraStateToSaveImage.map(screenState, imageByteArray)

            if (saveAlifeUseCase.saveImage(saveImageEntity) is UseCaseResult.Success)
                screenState.onImageLoaded(this@CreateAlifeReducer)
            else {
                Log.d("SaveAlifeUseCase", "Error")
                /*Show Error*/
            }
        }
    }

    override suspend fun onPermissionGranted() {
        setState { copy(screenState = CameraFirstScreenState()) }
    }

    override suspend fun onPermissionFatal() {
        setState { copy(screenState = ErrorScreenState()) }
    }
}