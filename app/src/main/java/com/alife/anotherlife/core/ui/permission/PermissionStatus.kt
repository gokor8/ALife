package com.alife.anotherlife.core.ui.permission

interface PermissionStatus {

    class Init : PermissionStatus
    class Success : PermissionStatus
    class Fail : PermissionStatus
    class Fatal : PermissionStatus
}