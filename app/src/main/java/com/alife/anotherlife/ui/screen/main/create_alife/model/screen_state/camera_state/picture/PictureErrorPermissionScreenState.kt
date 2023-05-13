package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture

import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ErrorPermissionScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction

class PictureErrorPermissionScreenState : ErrorPermissionScreenState(), BasePictureScreenState {

    override fun cameraPermissionAction(status: PermissionStatus) =
        CreateAlifeAction.PhotoPermission(status, this)
}