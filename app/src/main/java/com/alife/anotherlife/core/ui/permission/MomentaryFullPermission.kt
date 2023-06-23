package com.alife.anotherlife.core.ui.permission

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.permission.strategy.PermissionStrategy
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

abstract class MomentaryFullPermission(
    permission: String,
    permissionStrategy: PermissionStrategy,
    failDialog: AbstractDialog,
    fatalDialog: AbstractDialog,
    private val launchPermissionKey: Any = Unit,
) : FullPermission(permission, permissionStrategy, failDialog, fatalDialog) {

    @ExperimentalPermissionsApi
    @Composable
    override fun OnPermissionStateSetup(
        permissionState: PermissionState,
        onPermission: (PermissionStatus) -> Unit
    ) {
        LaunchedEffect(launchPermissionKey) { permissionState.launchPermissionRequest() }
    }
}