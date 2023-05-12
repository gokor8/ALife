package com.alife.anotherlife.core.ui.permission

import androidx.compose.runtime.*
import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.permission.strategy.PermissionStrategy
import com.google.accompanist.permissions.*

abstract class AbstractPermission(
    private val permission: String,
    private val permissionStrategy: PermissionStrategy,
    protected val failDialog: AbstractDialog,
) : BasePermission {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun requirePermission(permissionBoxer: PermissionBoxer): PermissionState {
        return requirePermission(permissionBoxer::reduceBox)
    }

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun requirePermission(onPermission: (PermissionStatus) -> Unit): PermissionState {
        var permissionStatus by remember {
            mutableStateOf<PermissionStatus>(PermissionStatus.Init())
        }

        val permission = permissionStrategy.rememberPermission(permission = permission) { status ->
            permissionStatus = status
            onPermission(status)
        }

        OnPermissionStateSetup(permission, onPermission)

        OnAllPermissionSetup(permission, permissionStatus, onPermission)

        return permission
    }

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    protected open fun OnPermissionStateSetup(
        permissionState: PermissionState,
        onPermission: (PermissionStatus) -> Unit
    ) = Unit

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    protected open fun OnAllPermissionSetup(
        permissionState: PermissionState,
        permissionStatus: PermissionStatus,
        onPermission: (PermissionStatus) -> Unit
    ) {
        failDialog.ShowDialog(
            permissionStatus is PermissionStatus.Fail,
            onAgree = { permissionState.launchPermissionRequest() },
            onDismiss = { onPermission(PermissionStatus.Fatal()) }
        )
    }
}