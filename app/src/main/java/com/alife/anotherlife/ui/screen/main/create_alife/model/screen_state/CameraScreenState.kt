package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state

import androidx.camera.core.CameraSelector
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraPreviewComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSetupFactory
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

class CameraScreenState(
    val cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
) : ScreenState.AbstractScreenState() {

    fun inverseCameraSelector() = if (cameraSelector == CameraSelector.DEFAULT_FRONT_CAMERA) {
        CameraSelector.DEFAULT_BACK_CAMERA
    } else {
        CameraSelector.DEFAULT_FRONT_CAMERA
    }

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun SafeContent(
        permissionState: PermissionState,
        viewModel: CreateAlifeViewModel,
    ) {
//        val cameraFacade = CameraSetupFactory().create(cameraSelector)
//
//        CameraPreviewComposable(cameraFacade, modifier = Modifier.fillMaxSize()) {
//            // viewModel set captureWrapper
//        }
    }
}