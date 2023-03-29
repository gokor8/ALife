package com.alife.anotherlife.ui.screen.main.create_alife.model

import android.content.Context
import androidx.camera.core.ImageCapture
import androidx.core.content.ContextCompat
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera_callback.CallbackImageCapture
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera_callback.SuspendImageCapture
import kotlin.coroutines.suspendCoroutine

class CameraWrapper(
    private val imageCapture: ImageCapture
) {

    suspend fun takePhoto(context: Context) = suspendCoroutine { continuation ->
        imageCapture.takePicture(
            ContextCompat.getMainExecutor(context),
            SuspendImageCapture(continuation)
        )
    }
}