package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture

import android.content.Context
import androidx.camera.core.ImageProxy
import java.util.concurrent.Executor
import kotlin.coroutines.suspendCoroutine

class EmptyCaptureWrapper : UselessCaptureWrapper {

    override suspend fun takePhoto(executor: Executor): ImageProxy = suspendCoroutine {  }
}