package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

interface BaseCameraPictureScreenState {
    suspend fun onImageLoaded(reducer: AbstractVMReducer<CreateAlifeState, CreateAlifeEffect>)
}

abstract class CameraPictureScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
) : CameraScreenState(cameraSelector), BaseCameraPictureScreenState {

    override fun cameraPermissionAction(status: PermissionStatus) =
        CreateAlifeAction.PhotoPermission(status, this)
}