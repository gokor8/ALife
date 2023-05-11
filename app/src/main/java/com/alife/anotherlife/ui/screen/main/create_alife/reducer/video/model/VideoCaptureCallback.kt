package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState

interface VideoCaptureCallback {
    fun setupVideoCaptureState(captureState: BaseStartVideoCaptureState)
}