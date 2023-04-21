package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.core.ImageProxy
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import java.lang.Exception
import java.util.concurrent.Executor

class FakeCaptureWrapper(private val exception: Exception? = null) : BaseCaptureWrapper {
    override suspend fun takePhoto(executor: Executor): ImageProxy {
        return exception?.let { throw exception } ?: FakeImageProxy()
    }
}