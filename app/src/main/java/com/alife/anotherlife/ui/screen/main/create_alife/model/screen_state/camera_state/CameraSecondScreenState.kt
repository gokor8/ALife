package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect

class CameraSecondScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
) : CameraScreenState(cameraSelector) {

    override suspend fun onImageLoaded(reducer: CreateAlifeReducer) {
        reducer.setEffect(CreateAlifeEffect.CreateAlifeFinish())
    }
}