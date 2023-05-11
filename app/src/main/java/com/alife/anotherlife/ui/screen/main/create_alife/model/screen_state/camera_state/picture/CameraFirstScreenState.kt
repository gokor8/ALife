package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture

import androidx.camera.core.CameraSelector
import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSelectorInverter
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Picture
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.BaseCreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

class CameraFirstScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
    private val cameraInverter: CameraSelectorInverter = CameraSelectorInverter(cameraSelector)
) : CameraPictureScreenState(cameraSelector), BaseInvertPictureScreenState {

    override fun invertCamera() = cameraInverter.invertCameraSelector()

    override fun copyInvertCamera(): CameraFirstScreenState {
        return CameraFirstScreenState(cameraInverter.invertCameraSelector())
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onImageLoaded(
        reducer: BaseCreateAlifePhotoReducer,
        captureWrapper: CookedCaptureWrapper
    ) {
        reducer.setState {
            copy(
                // TODO change to current item and call change
                pagerContainer = pagerContainer.changePicture(
                    Picture(
                        pagerItem = PicturePagerItem.DefaultTakePicture(captureWrapper),
                        screenState = CameraSecondScreenState(cameraInverter.invertCameraSelector())
                    )
                )
            )
        }
    }
}