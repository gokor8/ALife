package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture

import androidx.camera.video.Recorder
import androidx.camera.video.VideoCapture

class VideoCaptureWrapper(
    videoCapture: VideoCapture<Recorder>
) : BaseVideoCaptureWrapper.Abstract(videoCapture)