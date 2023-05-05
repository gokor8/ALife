package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state

import androidx.camera.video.Recorder
import androidx.camera.video.Recording
import androidx.camera.video.VideoCapture

class RecordingCaptureState(
    videoCapture: VideoCapture<Recorder>,
    private val recording: Recording
) : BaseVideoCaptureState.Abstract(videoCapture) {

    fun pause() {
        recording.pause()
    }

    fun resume() {
        recording.resume()
    }

    fun stop() {
        recording.stop()
    }
}