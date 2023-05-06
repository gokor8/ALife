package com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo

import androidx.camera.core.ImageProxy
import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.BaseCameraStateToSaveImage
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BaseCameraPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.CameraPermissionReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.create_alife.BaseSaveAlifeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.Executor
import javax.inject.Inject

class CreateAlifePhotoReducer @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>,
    private val cameraStateToSaveImage: BaseCameraStateToSaveImage,
    private val imageProxyToByteArray: Mapper<ImageProxy, ByteArray>,
    private val saveAlifeUseCase: BaseSaveAlifeUseCase
) : CameraPermissionReducer(uiStore), BaseCreateAlifePhotoReducer {

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onCreatePhoto(
        screenState: BaseCameraPictureScreenState,
        mainExecutor: Executor
    ) {
        setState {
            copy(pagerContainer = pagerContainer.changePicture(PicturePagerItem.OnPictureTaking()))
        }

        execute {
//            setState { TODO нужно ли это мне оставить?
//                copy(pagerContainer = pagerContainer.changePicture(PicturePagerItem.DefaultTakePicture()))
//            }
            // TODO заменить на попап с ошибкой, и анкомментед выше код
            setEffect(CreateAlifeEffect.CreateAlifeFinish())
        }.handleThis(uiStore.getState()) {
            val imageProxy = captureWrapper.takePhoto(mainExecutor)

            val imageBytes = withContext(Dispatchers.IO) { imageProxyToByteArray.map(imageProxy) }

            val saveImageEntity = cameraStateToSaveImage.map(screenState, imageBytes)

            saveAlifeUseCase.saveImage(saveImageEntity)

            screenState.onImageLoaded(this@CreateAlifePhotoReducer)
        }
    }
}