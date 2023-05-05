package com.alife.anotherlife.ui.screen.main.create_alife.model.camera

import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.BaseCameraSetupFacade
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.BaseCameraSetupFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.CaptureFactory

class CameraSetupFactory(
    private val captureFactory: CaptureFactory<*>
) : BaseCameraSetupFactory {

    override fun create(cameraSelector: CameraSelector): BaseCameraSetupFacade {
        return CameraPictureSetupFacade(
            cameraSelector,
            Preview.Builder(),
            captureFactory
        )
    }
}