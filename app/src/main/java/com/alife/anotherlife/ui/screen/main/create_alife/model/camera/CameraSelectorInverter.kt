package com.alife.anotherlife.ui.screen.main.create_alife.model.camera

import androidx.camera.core.CameraSelector

class CameraSelectorInverter(private val cameraSelector: CameraSelector) {

    fun invertCameraSelector(): CameraSelector {
        return if (cameraSelector == CameraSelector.DEFAULT_FRONT_CAMERA) {
            CameraSelector.DEFAULT_BACK_CAMERA
        } else {
            CameraSelector.DEFAULT_FRONT_CAMERA
        }
    }
}