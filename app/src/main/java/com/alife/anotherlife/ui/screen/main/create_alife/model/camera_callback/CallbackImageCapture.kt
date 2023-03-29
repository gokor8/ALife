package com.alife.anotherlife.ui.screen.main.create_alife.model.camera_callback

import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException

class CallbackImageCapture(
    private val actionOnError: (ImageCaptureException) -> Unit,
    private val actionOnSuccess: (ImageCapture.OutputFileResults) -> Unit
) : ImageCapture.OnImageSavedCallback {

    override fun onError(exception: ImageCaptureException) {
        actionOnError(exception)
    }

    override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
        actionOnSuccess(outputFileResults)
    }
}