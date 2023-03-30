package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.core.CameraSelector
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraPreviewComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSetupFactory

class CreateAlifeScreen : DefaultScreen() {

    @Composable
    override fun Content(modifier: Modifier) {
        // TODO hilt inject
        val cameraFacade = CameraSetupFactory().create(CameraSelector.DEFAULT_FRONT_CAMERA)

        CameraPreviewComposable(cameraFacade) {
            // viewModel set captureWrapper
        }
    }
}