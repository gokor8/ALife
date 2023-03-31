package com.alife.anotherlife.core.ui.permission.camera

import com.alife.core.mvi.MVI

interface CameraPermissionAction : MVI.Action {

    class Granted : CameraPermissionAction
}