package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state

import androidx.camera.core.CameraSelector
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.button.TransparentStrokeButton
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title22Style
import com.alife.anotherlife.core.ui.permission.camera.CameraPermissionBoxer
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraPreviewComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSetupFactory
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

interface ScreenState {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun Content(
        permissionState: PermissionState,
        viewModel: CreateAlifeViewModel,
        modifier: Modifier,
    )


    abstract class AbstractScreenState(
        private val contentAlignment: Alignment = Alignment.TopStart,
    ) : ScreenState {

        @OptIn(ExperimentalPermissionsApi::class)
        @Composable
        override fun Content(
            permissionState: PermissionState,
            viewModel: CreateAlifeViewModel,
            modifier: Modifier,
        ) {
            Box(
                contentAlignment = contentAlignment,
                modifier = modifier
            ) {
                SafeContent(permissionState, viewModel = viewModel)
            }
        }

        @OptIn(ExperimentalPermissionsApi::class)
        @Composable
        protected abstract fun SafeContent(
            permissionState: PermissionState,
            viewModel: CreateAlifeViewModel,
        )
    }

    class Load : AbstractScreenState(Alignment.Center) {

        @OptIn(ExperimentalPermissionsApi::class)
        @Composable
        override fun SafeContent(
            permissionState: PermissionState,
            viewModel: CreateAlifeViewModel,
        ) {
            CircularProgressIndicator(strokeWidth = 2.dp)
        }
    }

    class Camera : AbstractScreenState() {

        @OptIn(ExperimentalPermissionsApi::class)
        @Composable
        override fun SafeContent(
            permissionState: PermissionState,
            viewModel: CreateAlifeViewModel,
        ) {
            val cameraFacade = CameraSetupFactory().create(CameraSelector.DEFAULT_FRONT_CAMERA)

            CameraPreviewComposable(cameraFacade) {
                // viewModel set captureWrapper
            }
        }
    }

    class Error : AbstractScreenState(Alignment.Center) {

        @OptIn(ExperimentalPermissionsApi::class)
        @Composable
        override fun SafeContent(
            permissionState: PermissionState,
            viewModel: CreateAlifeViewModel,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                TextBase(
                    textResId = R.string.camera_blocking_error_camera,
                    style = Title22Style().style()
                )
                Spacer(modifier = Modifier.padding(bottom = 30.dp))

                TransparentStrokeButton(R.string.camera_blocking_error_camera) {
                    permissionState.launchPermissionRequest()
                }
            }
        }
    }
}