package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image

import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.BaseCameraSetupFacade
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.BaseCameraSetupFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.CaptureFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import javax.inject.Inject

class ImageSetupFactory @Inject constructor(
    private val captureFactory: CaptureFactory<ImageCapture>
) : BaseCameraSetupFactory<BaseCaptureWrapper> {

    override fun create(cameraSelector: CameraSelector): BaseCameraSetupFacade<BaseCaptureWrapper> {
        return CameraPictureSetupFacade(
            cameraSelector,
            Preview.Builder(),
            captureFactory
        )
    }
}