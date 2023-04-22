package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base

import androidx.camera.core.ImageCapture

interface ImageCaptureFactory {

    fun create(rotation: Int): ImageCapture
}