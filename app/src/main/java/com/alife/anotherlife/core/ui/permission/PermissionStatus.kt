package com.alife.anotherlife.core.ui.permission

import androidx.compose.runtime.Stable

@Stable
interface PermissionStatus {

    class Init : PermissionStatus
    class Success : PermissionStatus
    class Fail : PermissionStatus

    interface Fatality : PermissionStatus

    class PreFatal : Fatality
    class Fatal : Fatality
}