package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeReducer
import com.alife.anotherlife.ui.screen.main.create_alife.model.CameraSelectorInverter

class CameraFirstScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
    private val cameraInverter: CameraSelectorInverter = CameraSelectorInverter(cameraSelector)
) : CameraScreenState(cameraSelector), InvertibleCamera {

    override fun copyInvertCamera(): CameraFirstScreenState {
        val invertCameraSelector = cameraInverter.invertCameraSelector()

        return CameraFirstScreenState(invertCameraSelector)
    }

    override suspend fun onImageLoaded(reducer: CreateAlifeReducer) {
        reducer.setState {
            copy(
                screenState = CameraSecondScreenState(
                    cameraInverter.invertCameraSelector()
                )
            )
        }
    }
}