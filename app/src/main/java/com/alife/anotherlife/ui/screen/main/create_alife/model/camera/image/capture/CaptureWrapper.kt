package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture

import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageProxy
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.callback.SuspendOnImageCaptured
import java.util.concurrent.Executor
import kotlin.coroutines.suspendCoroutine

class CaptureWrapper(private val imageCapture: ImageCapture) : CookedCaptureWrapper {

    override suspend fun takePhoto(executor: Executor): ImageProxy =
        suspendCoroutine { continuation ->
            imageCapture.takePicture(
                executor,
                SuspendOnImageCaptured(continuation)
            )
        }
}