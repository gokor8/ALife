package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi

class CreateAlifeScreen(
    override val navController: NavController
) : VMScreen<CreateAlifeViewModel>() {

    @Composable
    override fun setupViewModel(): CreateAlifeViewModel = hiltViewModel()

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun Content(modifier: Modifier) {
        val cameraPermission = viewModel.cameraPermission.requirePermission { permissionState ->
            when(permissionState) {
                is PermissionStatus.Success -> {
                    viewModel.reduce(CreateAlifeAction.PermissionGrantedAction())
                }
                is PermissionStatus.Fatal -> {
                    viewModel.reduce(CreateAlifeAction.PermissionFatalAction())
                }
            }
        }

        viewModel.getUIState().screenState.Content(cameraPermission, viewModel, modifier)
    }
}