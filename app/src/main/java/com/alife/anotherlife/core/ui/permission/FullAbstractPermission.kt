package com.alife.anotherlife.core.ui.permission

import androidx.compose.runtime.Composable
import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.permission.strategy.PermissionStrategy
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

abstract class FullAbstractPermission(
    permission: String,
    permissionStrategy: PermissionStrategy,
    failDialog: AbstractDialog,
    private val fatalDialog: AbstractDialog
) : AbstractPermission(permission, permissionStrategy, failDialog) {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun OnAllPermissionSetup(
        permissionState: PermissionState,
        permissionStatus: PermissionStatus,
        onPermission: (PermissionStatus) -> Unit
    ) {
        super.OnAllPermissionSetup(permissionState, permissionStatus, onPermission)

        fatalDialog.ShowDialog(
            permissionStatus is PermissionStatus.PreFatal,
            onAgree = { permissionState.launchPermissionRequest() },
            onDismiss = { onPermission(PermissionStatus.Fatal()) }
        )
    }
}