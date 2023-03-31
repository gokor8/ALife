package com.alife.anotherlife.core.ui.permission

import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

abstract class AbstractPermission(
    private val permission: String
) : BasePermission {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun RequirePermission(onPermission: (PermissionState) -> Unit) {
        val rememberPermission = rememberPermissionState(permission)

        when {
            rememberPermission.status.isGranted -> PermissionState.Success()
            rememberPermission.status.shouldShowRationale -> PermissionState.Fail()
            else -> PermissionState.Fatal()
        }.also { permissionState ->
            if (permissionState is PermissionState.Fail) rememberPermission.launchPermissionRequest()
            onPermission(permissionState)
        }
    }

    @Composable
    protected abstract fun OnFatal()
}