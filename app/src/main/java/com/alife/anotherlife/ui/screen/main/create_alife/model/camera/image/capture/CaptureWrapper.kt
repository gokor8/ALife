package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture

import android.content.Context
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageProxy
import androidx.core.content.ContextCompat
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.callback.SuspendOnImageCaptured
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.concurrent.Executor
import kotlin.coroutines.suspendCoroutine

class CaptureWrapper(private val imageCapture: ImageCapture) : BaseCaptureWrapper {

    override suspend fun takePhoto(executor: Executor): ImageProxy =
        suspendCoroutine { continuation ->
            imageCapture.takePicture(
                executor,
                SuspendOnImageCaptured(continuation)
            )
        }
}