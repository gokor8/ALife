package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.core.ImageProxy
import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.reducer.HandlerVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.BaseCameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CameraPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraFirstScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ErrorScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleCamera
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.create_alife.BaseSaveAlifeUseCase
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CreateAlifeReducer @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>,
    private val cameraStateToSaveImage: BaseCameraStateToSaveImage,
    private val imageProxyToByteArray: Mapper<ImageProxy, ByteArray>,
    private val saveAlifeUseCase: BaseSaveAlifeUseCase
) : HandlerVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCreateAlifeReducer {

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onChangeCamera() {
        val currentScreenState = getState().screenState
        if (currentScreenState is InvertibleCamera) {
            setState { copy(screenState = currentScreenState.copyInvertCamera()) }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onCameraWrapper(captureWrapper: BaseCaptureWrapper) {
        setState { copy(captureWrapper = captureWrapper) }
    }

    override suspend fun onCreatePhoto(contextWrapper: BaseContextMainExecutorWrapper) {
        val mainExecutor = contextWrapper.getMainExecutor()
        val screenState = getState().screenState
        if (screenState !is CameraScreenState || mainExecutor == null) return

        setState { copyReplaceCamera(CameraPagerItem.OnPictureTaking()) }

        execute {
            setState { copyReplaceCamera(CameraPagerItem.TakePicture()) }
            setEffect(CreateAlifeEffect.CreateAlifeFinish())
        }.handleThis(uiStore.getState()) {
            val imageProxy = captureWrapper.takePhoto(mainExecutor)

            val imageBytes = withContext(Dispatchers.IO) { imageProxyToByteArray.map(imageProxy) }

            val saveImageEntity = cameraStateToSaveImage.map(screenState, imageBytes)

            saveAlifeUseCase.saveImage(saveImageEntity)

            screenState.onImageLoaded(this@CreateAlifeReducer)
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onClickSmallVideo() {
        getStateSuspend {
            setEffect(
                CreateAlifeEffect.VideoToMainPage(
                    pagerState, pagerItems.getVideoItemIndex()
                )
            )
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onPermissionGranted() {
        setState { copy(screenState = CameraFirstScreenState()) }
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onPermissionFatal() {
        setState { copy(screenState = ErrorScreenState()) }
    }
}