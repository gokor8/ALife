package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture

import androidx.camera.core.CameraSelector
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraPreviewComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

interface BasePictureScreenState : ScreenState

interface BaseInvertPictureScreenState : BasePictureScreenState,
    InvertibleScreenState<BaseInvertPictureScreenState>


interface PictureScreenState : BasePictureScreenState {
    suspend fun onImageLoaded(
        reducer: AbstractVMReducer<CreateAlifeState, CreateAlifeEffect>,
        captureWrapper: CookedCaptureWrapper
    )
}

abstract class CameraPictureScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
) : CameraScreenState(cameraSelector), BasePictureScreenState, PictureScreenState {

    @Composable
    override fun SafeContent(viewModel: CreateAlifeViewModel) {
        CameraPreviewComposable(
            viewModel.imageSetupFactory.create(cameraSelector),
            modifier = Modifier.fillMaxSize()
        ) { viewModel.reduce(CreateAlifeAction.OnCaptureWrapper(it)) }
    }

    override fun cameraPermissionAction(status: PermissionStatus) =
        CreateAlifeAction.PhotoPermission(status, this)
}