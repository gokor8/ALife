package com.alife.anotherlife.core.ui.permission

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

abstract class MomentaryPermission(
    permission: String,
    permissionStrategy: PermissionStrategy,
    alertDialog: AbstractDialog,
) : AbstractPermission(permission, permissionStrategy, alertDialog) {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun OnPermissionStateSetup(
        permissionState: PermissionState,
        onPermission: (PermissionStatus) -> Unit
    ) { LaunchedEffect(Unit) { permissionState.launchPermissionRequest() } }
}