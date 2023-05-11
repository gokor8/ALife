package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.options

import android.util.Size
import androidx.camera.core.ImageCapture

class ImageCaptureOptions : BaseImageCaptureOptions {

    private val size = Size(1920, 1080)

    override fun create(rotation: Int): ImageCapture {
        return ImageCapture.Builder()
            .setTargetRotation(rotation)
            .setCaptureMode(ImageCapture.CAPTURE_MODE_MAXIMIZE_QUALITY)
            .setTargetResolution(size)
            .build()
    }
}