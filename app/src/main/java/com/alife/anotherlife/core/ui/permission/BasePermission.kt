package com.alife.anotherlife.core.ui.permission

import androidx.compose.runtime.Composable

interface BasePermission {

    @Composable
    fun RequirePermission(onPermission: (PermissionState) -> Unit)
}