package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base

import androidx.camera.core.CameraSelector

interface BaseCameraSetupFactory<R : Any> {

    fun create(cameraSelector: CameraSelector): BaseCameraSetupFacade<R>
}