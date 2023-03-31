package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.core.CameraSelector
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.ui.permission.CameraPermission
import com.alife.anotherlife.core.ui.permission.PermissionState
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraPreviewComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSetupFactory
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import javax.inject.Inject

class CreateAlifeScreen(
    override val navController: NavController
) : VMScreen<CreateAlifeViewModel>() {

    @Inject
    lateinit var cameraPermission: CameraPermission

    @Composable
    override fun setupViewModel(): CreateAlifeViewModel = hiltViewModel()

    @Composable
    override fun Content(modifier: Modifier) {
        // TODO hilt inject
        cameraPermission.RequirePermission { permissionState ->
            when(permissionState) {
                is PermissionState.Success -> {
                    viewModel.reduce(CreateAlifeAction.PermissionGrantedAction())
                }
            }
        }
    }
}