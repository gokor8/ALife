package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.callback

import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class SuspendOnImageSaved(
    private val continuation: Continuation<ImageCapture.OutputFileResults>
) : ImageCapture.OnImageSavedCallback {

    override fun onError(exception: ImageCaptureException) {
        continuation.resumeWithException(exception)
    }

    override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
        continuation.resume(outputFileResults)
    }
}