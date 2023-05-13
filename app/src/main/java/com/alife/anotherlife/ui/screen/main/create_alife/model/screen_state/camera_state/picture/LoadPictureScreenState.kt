package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi

class LoadPictureScreenState : LoadScreenState, BasePictureScreenState {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun Content(viewModel: CreateAlifeViewModel, modifier: Modifier) {
        viewModel.cameraPermission.requirePermission { status ->
            viewModel.reduce(
                CreateAlifeAction.PhotoPermission(status, CameraFirstScreenState())
            )
        }

        super.Content(viewModel, modifier)
    }
}