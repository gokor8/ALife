package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state

import androidx.camera.core.CameraSelector
import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.reducer.VMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.model.CameraSelectorInverter
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

class ScreenFirstScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
    private val cameraInverter: CameraSelectorInverter = CameraSelectorInverter(cameraSelector)
) : CameraScreenState(cameraSelector), InvertibleScreenState {

    override fun copyInvertCamera(): ScreenFirstScreenState {
        val invertCameraSelector = cameraInverter.invertCameraSelector()

        return ScreenFirstScreenState(invertCameraSelector)
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onImageLoaded(reducer: VMReducer<CreateAlifeState, CreateAlifeEffect>) {
        reducer.setState {
            copy(
                pagerItems = pagerItems.copy(
                    picture = pagerItems.picture.copy(
                        pagerItem = PicturePagerItem.TakePicture(),
                        screenState = CameraSecondScreenState(cameraInverter.invertCameraSelector())
                    )
                )
            )
        }
    }
}