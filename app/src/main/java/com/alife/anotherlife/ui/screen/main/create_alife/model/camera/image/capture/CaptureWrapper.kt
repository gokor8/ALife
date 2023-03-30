package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture

import android.content.Context
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageProxy
import androidx.core.content.ContextCompat
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.callback.SuspendOnImageCaptured
import kotlin.coroutines.suspendCoroutine

class CaptureWrapper(private val imageCapture: ImageCapture) : BaseCaptureWrapper {

    override suspend fun takePhoto(context: Context): ImageProxy =
        suspendCoroutine { continuation ->
            imageCapture.takePicture(
                ContextCompat.getMainExecutor(context),
                SuspendOnImageCaptured(continuation)
            )
        }
}