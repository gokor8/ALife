package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture

import android.content.Context
import androidx.camera.core.ImageProxy
import kotlin.coroutines.suspendCoroutine

class ErrorCaptureWrapper : BaseCaptureWrapper {

    override suspend fun takePhoto(context: Context): ImageProxy = suspendCoroutine {  }
}