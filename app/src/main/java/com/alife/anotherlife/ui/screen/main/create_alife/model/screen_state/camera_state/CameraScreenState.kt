package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state

import androidx.camera.core.CameraSelector
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.ui.reducer.VMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraPreviewComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSetupFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

abstract class CameraScreenState(
    val cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
) : ScreenState {

    @Composable
    override fun Content(
        viewModel: CreateAlifeViewModel,
        modifier: Modifier
    ) {
        val cameraFacade = CameraSetupFactory().create(cameraSelector)

        CameraPreviewComposable(
            cameraFacade,
            modifier = Modifier.fillMaxSize()
        ) { viewModel.reduce(CreateAlifeAction.OnCaptureWrapper(it)) }
    }

    abstract suspend fun onImageLoaded(reducer: VMReducer<CreateAlifeState, CreateAlifeEffect>)
}