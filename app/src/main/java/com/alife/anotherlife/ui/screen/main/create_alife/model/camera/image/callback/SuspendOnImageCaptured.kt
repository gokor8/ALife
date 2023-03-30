package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.callback

import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class SuspendOnImageCaptured(
    private val continuation: Continuation<ImageProxy>
) : ImageCapture.OnImageCapturedCallback() {

    override fun onError(exception: ImageCaptureException) {
        continuation.resumeWithException(exception)
    }

    override fun onCaptureSuccess(image: ImageProxy) {
        continuation.resume(image)
    }
}