package com.alife.anotherlife.ui.screen.main.create_alife.addons.permission_wrapper

import androidx.compose.runtime.Composable
import com.alife.anotherlife.core.composable.addons.stable
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.permission.camera.CameraPermission
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.core.mvi.MVIReducer
import com.google.accompanist.permissions.ExperimentalPermissionsApi

class CameraPermissionWrapper(
    private val cameraPermission: CameraPermission
) : CreateAlifePermissionWrapper {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun SetupPermissions(
        action: MVIReducer.Base<CreateAlifeAction>,
        screenState: ScreenState
    ) {
        cameraPermission.requirePermission(
            onPermission = stable { permissionState ->
                action.reduce(
                    CreateAlifeAction.PhotoPermission(permissionState is PermissionStatus.Success)
                )
            }
        )
    }
}