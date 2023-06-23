package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video

import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.video.Recorder
import androidx.camera.video.VideoCapture
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.BaseCameraSetupFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.CaptureFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import javax.inject.Inject

class VideoSetupFactory @Inject constructor(
    private val captureFactory: CaptureFactory<VideoCapture<Recorder>>
) : BaseCameraSetupFactory<BaseVideoCaptureWrapper> {

    override fun create(cameraSelector: CameraSelector) = CameraVideoSetupFacade(
        cameraSelector,
        Preview.Builder(),
        captureFactory
    )
}