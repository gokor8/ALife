package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi

class LoadVideoScreenState : LoadScreenState() {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun Content(viewModel: CreateAlifeViewModel, modifier: Modifier) {
        val audioPermissionState = viewModel.audioPermission.requirePermission(viewModel)

        viewModel.cameraPermission.requirePermission { status ->
            viewModel.reduce(
                CreateAlifeAction.VideoPermission(status, CameraVideoScreenState())
            )

            if(status is PermissionStatus.Success) audioPermissionState.launchPermissionRequest()
        }

        super.Content(viewModel, modifier)
    }
}