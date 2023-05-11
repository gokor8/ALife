package com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model

import com.alife.anotherlife.ui.screen.main.create_alife.FakeImageProxy
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.UselessCaptureWrapper
import java.util.concurrent.Executor

interface FakeCaptureWrapper : BaseCaptureWrapper {
    class CookedWrapper : CookedCaptureWrapper, FakeCaptureWrapper {
        override suspend fun takePhoto(executor: Executor) = FakeImageProxy()
    }

    class UselessWrapper : UselessCaptureWrapper, FakeCaptureWrapper {
        override suspend fun takePhoto(executor: Executor) = throw IllegalStateException()
    }

    class EmptyWrapper : FakeCaptureWrapper {
        override suspend fun takePhoto(executor: Executor) = throw IllegalStateException()
    }
}