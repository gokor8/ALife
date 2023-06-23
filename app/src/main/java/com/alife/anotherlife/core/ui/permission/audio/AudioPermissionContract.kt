package com.alife.anotherlife.core.ui.permission.audio

import com.alife.anotherlife.core.ui.permission.PermissionStatus

interface AudioPermissionContract {

    fun audioBoxReduce(permissionStatus: PermissionStatus)
}