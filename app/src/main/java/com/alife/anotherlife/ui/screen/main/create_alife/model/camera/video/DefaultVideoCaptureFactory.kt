package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video

import androidx.camera.video.Recorder
import androidx.camera.video.VideoCapture
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.CaptureFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.VideoRecorder

class DefaultVideoCaptureFactory(
    private val videoRecorder: VideoRecorder
): CaptureFactory<VideoCapture<Recorder>> {

    override fun create(rotation: Int): VideoCapture<Recorder> {
        return VideoCapture.withOutput(videoRecorder.build())
    }
}