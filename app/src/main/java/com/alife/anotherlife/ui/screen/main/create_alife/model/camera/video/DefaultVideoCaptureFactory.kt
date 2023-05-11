package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video

import androidx.camera.video.Recorder
import androidx.camera.video.VideoCapture
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.CaptureFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.VideoRecorder
import javax.inject.Inject

class DefaultVideoCaptureFactory @Inject constructor(): CaptureFactory<VideoCapture<Recorder>> {

    override fun create(rotation: Int): VideoCapture<Recorder> {
        return VideoCapture.withOutput(VideoRecorder.Default().build())
    }
}