package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.addons.permission_wrapper.CameraPermissionWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState

class LoadPictureScreenState(
    private val cameraPermissionWrapper: CameraPermissionWrapper
) : LoadScreenState() {

    @Composable
    override fun Content(viewModel: CreateAlifeViewModel, modifier: Modifier) {
        cameraPermissionWrapper.SetupPermissions(viewModel, CameraFirstScreenState(cameraPermissionWrapper = cameraPermissionWrapper))

        super.Content(viewModel, modifier)
    }
}