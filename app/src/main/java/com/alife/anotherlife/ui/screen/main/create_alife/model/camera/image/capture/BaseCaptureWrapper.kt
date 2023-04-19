package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture

import android.content.Context
import androidx.camera.core.ImageProxy
import androidx.compose.runtime.Stable
import java.util.concurrent.Executor


@Stable
interface BaseCaptureWrapper {

    suspend fun takePhoto(executor: Executor): ImageProxy
}