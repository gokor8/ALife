package com.alife.anotherlife.core.ui.permission

import androidx.compose.runtime.Stable

@Stable
interface PermissionStatus {

    class Init : PermissionStatus
    class Success : PermissionStatus
    class Fail : PermissionStatus
    class Fatal : PermissionStatus
}