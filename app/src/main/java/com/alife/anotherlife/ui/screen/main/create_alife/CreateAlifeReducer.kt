package com.alife.anotherlife.ui.screen.main.create_alife

import android.content.ContextWrapper
import android.util.Log
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.reducer.HandlerVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.ContextMainThreadWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.BaseCameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.ImageProxyToByteArray
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.ImageProxyToYuvByteArray
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CameraPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraFirstScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ErrorScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleCamera
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.main.create_alife.BaseSaveAlifeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CreateAlifeReducer @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>,
    private val cameraStateToSaveImage: BaseCameraStateToSaveImage,
    private val saveAlifeUseCase: BaseSaveAlifeUseCase
) : HandlerVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCreateAlifeReducer {

    override suspend fun onChangeCamera() {
        val currentScreenState = getState().screenState
        if (currentScreenState is InvertibleCamera) {
            setState { copy(screenState = currentScreenState.copyInvertCamera()) }
        }
    }

    override suspend fun onCameraWrapper(captureWrapper: BaseCaptureWrapper) {
        setState { copy(captureWrapper = captureWrapper) }
    }

    override suspend fun onStartTakePhoto(pagerItem: CameraPagerItem) {
        setState { copy(pagerItems = pagerItems.replaceCamera(pagerItem)) }
    }

    override suspend fun onTakePhoto(imageByteArray: ByteArray) {
        getStateSuspend {
            if (screenState !is CameraScreenState) return@getStateSuspend

            val saveImageEntity = cameraStateToSaveImage.map(screenState, imageByteArray)

            if (saveAlifeUseCase.saveImage(saveImageEntity) is UseCaseResult.Success) {
                screenState.onImageLoaded(this@CreateAlifeReducer)
            } else {
                Log.d("SaveAlifeUseCase", "Error")
                /*Show Error*/
            }
        }
    }

    override suspend fun onCreatePhoto(contextWrapper: ContextMainThreadWrapper) {
        setState { copyReplaceCamera(CameraPagerItem.OnPictureTaking()) }

        execute {}.handleThis(uiStore.getState()) {
            val mainExecutor = contextWrapper.getMainExecutor()
            if (screenState !is CameraScreenState || mainExecutor == null) return@handleThis

            val imageProxy = captureWrapper.takePhoto(mainExecutor)

            val imageByteArray = withContext(Dispatchers.IO) {
                if (imageProxy.planes.size > 1)
                    ImageProxyToYuvByteArray().map(imageProxy)
                else
                    ImageProxyToByteArray().map(imageProxy)
            }

            val saveImageEntity = cameraStateToSaveImage.map(screenState, imageByteArray)

            saveAlifeUseCase.saveImage(saveImageEntity)

            screenState.onImageLoaded(this@CreateAlifeReducer)
        }
    }

    override suspend fun onPermissionGranted() {
        setState { copy(screenState = CameraFirstScreenState()) }
    }

    override suspend fun onPermissionFatal() {
        setState { copy(screenState = ErrorScreenState()) }
    }
}