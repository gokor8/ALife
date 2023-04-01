package com.alife.anotherlife.core.ui.permission

import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

interface BasePermission {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun requirePermission(onPermission: (PermissionStatus) -> Unit): PermissionState
}