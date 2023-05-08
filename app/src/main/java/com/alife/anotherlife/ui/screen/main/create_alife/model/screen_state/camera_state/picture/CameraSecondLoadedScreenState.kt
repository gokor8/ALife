package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

class CameraSecondLoadedScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
) : CameraPictureLoadedScreenState(cameraSelector) {

    override suspend fun onImageLoaded(
        reducer: AbstractVMReducer<CreateAlifeState, CreateAlifeEffect>,
        captureWrapper: CookedCaptureWrapper
    ) {
        reducer.setEffect(CreateAlifeEffect.CreateAlifeFinish())
    }
}