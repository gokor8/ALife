package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state

import androidx.camera.core.CameraSelector
import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.reducer.VMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSelectorInverter
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.CameraPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

class CameraFirstScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
    private val cameraInverter: CameraSelectorInverter = CameraSelectorInverter(cameraSelector)
) : CameraPictureScreenState(cameraSelector), InvertibleScreenState {

    override fun copyInvertCamera(): CameraFirstScreenState {
        val invertCameraSelector = cameraInverter.invertCameraSelector()

        return CameraFirstScreenState(invertCameraSelector)
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onImageLoaded(reducer: VMReducer<CreateAlifeState, CreateAlifeEffect>) {
        reducer.setState {
            copy(
                pagerItems = pagerItems.copy(
                    picture = pagerItems.picture.copy(
                        pagerItem = PicturePagerItem.DefaultTakePicture(),
                        screenState = CameraSecondScreenState(cameraInverter.invertCameraSelector())
                    )
                )
            )
        }
    }
}