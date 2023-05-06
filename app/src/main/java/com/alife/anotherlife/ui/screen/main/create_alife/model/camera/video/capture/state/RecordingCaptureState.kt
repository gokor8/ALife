package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording.RecordingWrapper

class RecordingCaptureState(
    val videoCapture: BaseStartVideoCaptureState,
    private val recordingWrapper: RecordingWrapper
) : BaseVideoCaptureState {

    fun pause() {
        recordingWrapper.pause()
    }

    fun resume() {
        recordingWrapper.resume()
    }

    fun stop() {
        recordingWrapper.stop()
    }
}