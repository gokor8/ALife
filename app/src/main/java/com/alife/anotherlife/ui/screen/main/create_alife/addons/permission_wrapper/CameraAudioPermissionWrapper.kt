package com.alife.anotherlife.ui.screen.main.create_alife.addons.permission_wrapper

import androidx.compose.runtime.Composable
import com.alife.anotherlife.core.composable.addons.stable
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.permission.audio.AudioPermission
import com.alife.anotherlife.core.ui.permission.camera.CameraPermission
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.core.mvi.MVIReducer
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import javax.inject.Inject

class CameraAudioPermissionWrapper @Inject constructor(
    //private val cameraPermissionWrapper: CameraPermissionWrapper,
    private val cameraPermission: CameraPermission,
    private val audioPermission: AudioPermission
) : CreateAlifePermissionWrapper {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun SetupPermissions(
        action: MVIReducer.Base<CreateAlifeAction>,
        screenState: ScreenState
    ) {
        val audioPermission = audioPermission.requirePermission { permissionState ->
            action.reduce(CreateAlifeAction.AudioPermission(permissionState))
        }

        // TODO проверять в листе(цепочке), если тстатус Granted, либо Fatal, запускать второй пермишн


        // TODO Fix me
        cameraPermission.requirePermission(
            onPermission = stable { permissionState ->
                val isGranted = permissionState is PermissionStatus.Success

                action.reduce(
                    CreateAlifeAction.PhotoPermission(
                        permissionState is PermissionStatus.Success,
                        screenState
                    )
                )

                if(isGranted) audioPermission.launchPermissionRequest()
            }
        )
    }
}