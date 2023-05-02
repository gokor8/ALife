package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.CameraPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

class CameraSecondScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
) : CameraPictureScreenState(cameraSelector) {

    override suspend fun onImageLoaded(reducer: AbstractVMReducer<CreateAlifeState, CreateAlifeEffect>) {
        reducer.setEffect(CreateAlifeEffect.CreateAlifeFinish())
    }
}