package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture

import android.content.Context
import androidx.camera.core.ImageProxy
import androidx.compose.runtime.Stable


@Stable
interface BaseCaptureWrapper {

    suspend fun takePhoto(context: Context): ImageProxy
}