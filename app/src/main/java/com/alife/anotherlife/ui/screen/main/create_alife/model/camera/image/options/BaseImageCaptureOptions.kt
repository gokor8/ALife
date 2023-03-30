package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.options

import androidx.camera.core.ImageCapture

interface BaseImageCaptureOptions {

    fun create(rotation: Int): ImageCapture
}