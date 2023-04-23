package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeReducer
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraScreenState

abstract class CameraPictureScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
) : CameraScreenState(cameraSelector) {

    abstract suspend fun onImageLoaded(reducer: CreateAlifeReducer)
}