package com.alife.anotherlife.ui.screen.main.create_alife.model

import androidx.camera.core.CameraSelector

class CameraSelectorInverter {

    fun invertCameraSelector(cameraSelector: CameraSelector): CameraSelector {
        return if (cameraSelector == CameraSelector.DEFAULT_FRONT_CAMERA) {
            CameraSelector.DEFAULT_BACK_CAMERA
        } else {
            CameraSelector.DEFAULT_FRONT_CAMERA
        }
    }
}