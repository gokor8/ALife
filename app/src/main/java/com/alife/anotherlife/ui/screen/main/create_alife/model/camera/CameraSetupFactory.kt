package com.alife.anotherlife.ui.screen.main.create_alife.model.camera

import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import com.alife.anotherlife.ui.screen.main.create_alife.model.DefaultImageCaptureFactory

class CameraSetupFactory : BaseCameraSetupFactory {

    override fun create(cameraSelector: CameraSelector): BaseCameraSetupFacade {
        CameraSelector.DEFAULT_BACK_CAMERA
        return CameraSetupFacade(
            cameraSelector,
            Preview.Builder(),
            DefaultImageCaptureFactory()
        )
    }
}