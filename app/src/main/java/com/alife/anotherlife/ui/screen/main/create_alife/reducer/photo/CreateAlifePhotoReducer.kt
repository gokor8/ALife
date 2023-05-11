package com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo

import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.BaseCameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.image.BaseImageProxyToBytes
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BasePictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.PictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.CameraPermissionReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.domain.core.coroutine_await_list.BaseCoroutineAwaitList
import com.alife.domain.main.create_alife.picture.BaseSaveAlifeUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import javax.inject.Inject

class CreateAlifePhotoReducer @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>,
    private val cameraStateToSaveImage: BaseCameraStateToSaveImage,
    private val imageProxyToByteArray: BaseImageProxyToBytes,
    private val saveAlifeUseCase: BaseSaveAlifeUseCase,
    private val coroutineAwaitList: BaseCoroutineAwaitList
) : CameraPermissionReducer<BasePictureScreenState>(uiStore), BaseCreateAlifePhotoReducer {

    override fun changeCurrentScreen(screenState: BasePictureScreenState) = getState {
        pagerContainer.picture.copyContainer(pagerContainer, screenState)
    }

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCaptureWrapper(captureWrapper: CookedCaptureWrapper) {
        setState {
            copy(
                pagerContainer = pagerContainer.copy(
                    picture = pagerContainer.picture.copy(
                        PicturePagerItem.DefaultTakePicture(captureWrapper)
                    )
                )
            )
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onCreatePhoto(
        viewModelScope: CoroutineScope,
        screenState: PictureScreenState,
        captureWrapper: CookedCaptureWrapper,
        contextWrapper: BaseContextMainExecutorWrapper
    ) {
        setState {
            copy(pagerContainer = pagerContainer.changePicture(PicturePagerItem.OnPictureTaking()))
        }

        executeExceptionHandler {
//            setState { TODO нужно ли это мне оставить?
//                copy(pagerContainer = pagerContainer.changePicture(PicturePagerItem.DefaultTakePicture()))
//            }
            // TODO заменить на попап с ошибкой, и анкомментед выше код
            //setState { copy(blockingScreen = null) }
            trySetEffect(CreateAlifeEffect.CreateAlifeFinish())
        }.handleThis(uiStore.getState()) { exHandler ->
            val imageProxy = captureWrapper.takePhoto(contextWrapper.getMainExecutor())

            coroutineAwaitList.addAndLaunch(viewModelScope, exHandler + Dispatchers.Default) {
                val imageBytes = imageProxyToByteArray.map(
                    imageProxy.planes[0].buffer,
                    imageProxy.imageInfo.rotationDegrees.toFloat()
                )

                val saveImageEntity = cameraStateToSaveImage.map(screenState, imageBytes)

                saveAlifeUseCase.saveImage(saveImageEntity)
            }

            screenState.onImageLoaded(this@CreateAlifePhotoReducer, captureWrapper)
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onFinish() {
        if (!coroutineAwaitList.isComplete()) {
            setState { copy(lceModel = LCELoading) }
            coroutineAwaitList.joinAll(Dispatchers.IO)
        }

        setEffect(CreateAlifeEffect.CreateAlifeFinish())
        setState { copy(lceModel = LCEContent) }
    }
}