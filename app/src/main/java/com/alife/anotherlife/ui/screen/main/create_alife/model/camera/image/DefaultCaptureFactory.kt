package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image

import androidx.camera.core.ImageCapture
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.CaptureFactory

class DefaultCaptureFactory: CaptureFactory<ImageCapture> {

    override fun create(rotation: Int): ImageCapture {
        return ImageCapture.Builder()
            .setTargetRotation(rotation)
            .setCaptureMode(ImageCapture.CAPTURE_MODE_MAXIMIZE_QUALITY)
            .build()
    }
}