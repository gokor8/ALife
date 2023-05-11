package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video

import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.video.Recorder
import androidx.camera.video.VideoCapture
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSetupFacade
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.CaptureFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.ErrorVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.VideoCaptureWrapper
import javax.inject.Inject

class CameraVideoSetupFacade @Inject constructor(
    cameraSelector: CameraSelector,
    previewBuilder: Preview.Builder,
    captureFactory: CaptureFactory<VideoCapture<Recorder>>
) : CameraSetupFacade<VideoCapture<Recorder>, BaseVideoCaptureWrapper>(
    cameraSelector, previewBuilder, captureFactory
) {
    override fun onBind(capture: VideoCapture<Recorder>) = VideoCaptureWrapper(capture)

    override fun onException(ex: Exception) = ErrorVideoCaptureWrapper()
}