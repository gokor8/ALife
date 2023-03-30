package com.alife.anotherlife.ui.screen.main.create_alife.model.camera

import androidx.camera.core.CameraSelector

interface BaseCameraSetupFactory {

    fun create(cameraSelector: CameraSelector): BaseCameraSetupFacade
}