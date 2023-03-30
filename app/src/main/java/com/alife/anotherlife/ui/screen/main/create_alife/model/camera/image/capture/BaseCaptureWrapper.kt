package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture

import android.content.Context
import androidx.camera.core.ImageProxy


interface BaseCaptureWrapper {

    suspend fun takePhoto(context: Context): ImageProxy
}