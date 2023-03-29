package com.alife.anotherlife.ui.screen.main.create_alife.model

import androidx.camera.core.ImageCapture

interface ImageCaptureFactory {

    fun create(rotation: Int): ImageCapture
}