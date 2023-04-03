package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.compose.runtime.Stable
import com.alife.anotherlife.core.composable.mvi_extensions.DefaultViewModel
import com.alife.anotherlife.core.ui.permission.camera.CameraPermission
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateAlifeViewModel @Inject constructor(
    reducer: BaseCreateAlifeReducer,
    val cameraPermission: CameraPermission
) : DefaultViewModel<BaseCreateAlifeReducer, CreateAlifeAction, CreateAlifeState, CreateAlifeEffect>(
    reducer
)