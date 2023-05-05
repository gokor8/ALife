package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state

import androidx.camera.video.Recorder
import androidx.camera.video.VideoCapture

interface BaseVideoCaptureState {

    abstract class Abstract(protected val videoCapture: VideoCapture<Recorder>): BaseVideoCaptureState
}