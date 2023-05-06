package com.alife.anotherlife.ui.screen.main.create_alife.reducer_video

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.mapper.VideoCaptureWrapperToState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseFileOutputOptions
import com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.FakeCreateAlifeVideoReducer
import org.junit.Test

class TestVideoCaptureWrapperToState {

    private val videoCaptureWrapperToState: VideoCaptureWrapperToState = VideoCaptureWrapperToState()

    @Test(expected = IllegalStateException::class)
    fun `test map if success state return exception`() {
        videoCaptureWrapperToState.map(FakeCreateAlifeVideoReducer(), )
    }

    // Fake Realization
    class FakeOutputOptions : BaseFileOutputOptions {
        override fun options() = throw IllegalStateException()
    }
}