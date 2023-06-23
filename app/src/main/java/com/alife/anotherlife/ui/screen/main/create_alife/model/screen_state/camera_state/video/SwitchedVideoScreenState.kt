package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSelectorInverter
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction

class SwitchedVideoScreenState(
    cameraSelector: CameraSelector,
    private val inverter: CameraSelectorInverter = CameraSelectorInverter(cameraSelector)
) : AbstractVideoScreenState(cameraSelector) {

    override fun onVideoWrapper(
        captureWrapper: BaseVideoCaptureWrapper
    ) = CreateAlifeAction.OnVideoWrapper.Switched(captureWrapper)

    override fun copyInvertCamera() = SwitchedVideoScreenState(inverter.invertCameraSelector())

    override fun invertCamera() = inverter.invertCameraSelector()
}