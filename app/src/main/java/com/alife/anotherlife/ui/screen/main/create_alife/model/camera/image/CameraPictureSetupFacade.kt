package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image

import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSetupFacade
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.CaptureFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.ErrorCaptureWrapper

class CameraPictureSetupFacade(
    cameraSelector: CameraSelector,
    previewBuilder: Preview.Builder,
    captureFactory: CaptureFactory<ImageCapture>
) : CameraSetupFacade<ImageCapture, BaseCaptureWrapper>(
    cameraSelector, previewBuilder, captureFactory
) {
    override fun onBind(capture: ImageCapture) = CaptureWrapper(capture)

    override fun onException(ex: Exception) = ErrorCaptureWrapper()

}