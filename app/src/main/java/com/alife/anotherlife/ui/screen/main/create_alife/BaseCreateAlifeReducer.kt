package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.core.ui.reducer.VMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

interface BaseCreateAlifeReducer : VMReducer<CreateAlifeState, CreateAlifeEffect> {

    suspend fun onChangeCamera()

    suspend fun onPermissionGranted()
    suspend fun onPermissionSelect()
    suspend fun onPermissionFatal()
}