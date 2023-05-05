package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture

import androidx.camera.core.CameraSelector
import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSelectorInverter
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Picture
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

class CameraFirstScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
    private val cameraInverter: CameraSelectorInverter = CameraSelectorInverter(cameraSelector)
) : CameraPictureScreenState(cameraSelector), InvertibleScreenState {

    override fun copyInvertCamera(): CameraFirstScreenState {
        return CameraFirstScreenState(cameraInverter.invertCameraSelector())
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onImageLoaded(reducer: AbstractVMReducer<CreateAlifeState, CreateAlifeEffect>) {
        reducer.setState {
            copy(
                // TODO change to current item and call change
                pagerContainer = pagerContainer.changePicture(
                    Picture(
                        pagerItem = PicturePagerItem.DefaultTakePicture(),
                        screenState = CameraSecondScreenState(cameraInverter.invertCameraSelector())
                    )
                )
            )
        }
    }
}