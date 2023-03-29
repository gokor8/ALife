package com.alife.anotherlife.ui.screen.main.create_alife.model

import android.util.Size
import androidx.camera.core.ImageCapture

class DefaultImageCaptureFactory: ImageCaptureFactory {

    private val size = Size(1920, 1080)

    override fun create(rotation: Int): ImageCapture {
        return ImageCapture.Builder()
            .setTargetRotation(rotation)
            .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
            .setTargetResolution(size)
            .build()
    }
}