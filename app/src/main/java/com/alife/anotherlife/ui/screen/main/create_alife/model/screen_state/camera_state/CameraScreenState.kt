package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state

import androidx.camera.core.CameraSelector
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi

abstract class CameraScreenState(
    val cameraSelector: CameraSelector
) : ScreenState.AbstractScreenState() {

    @Composable
    override fun TopRowContent(
        viewModel: CreateAlifeViewModel,
        modifier: Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            TextBase(
                textResId = R.string.horizontal_short_logo,
                style = Title28Style().style()
            )
        }
    }

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun SetupPermission(viewModel: CreateAlifeViewModel) {
        viewModel.momentaryCameraPermission.requirePermission { status ->
            viewModel.reduce(cameraPermissionAction(status))
        }
    }

    protected abstract fun cameraPermissionAction(
        status: PermissionStatus
    ): CreateAlifeAction.CameraPermission<*>
}

