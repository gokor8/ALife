package com.alife.anotherlife.core.ui.permission

interface PermissionState {

    class Success : PermissionState
    class Fail : PermissionState
    class Fatal : PermissionState
}