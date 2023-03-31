package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state

import androidx.camera.core.CameraSelector
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.button.TransparentStrokeButton
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title22Style
import com.alife.anotherlife.core.ui.permission.camera.CameraPermissionBoxer
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraPreviewComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSetupFactory

interface ScreenState {

    @Composable
    fun Content()

    class Load : ScreenState {

        @Composable
        override fun Content() {
            CircularProgressIndicator(strokeWidth = 2.dp)
        }
    }

    class Camera : ScreenState {

        @Composable
        override fun Content() {
            val cameraFacade = CameraSetupFactory().create(CameraSelector.DEFAULT_FRONT_CAMERA)

            CameraPreviewComposable(cameraFacade) {
                // viewModel set captureWrapper
            }
        }
    }

    class Error : ScreenState {

        @Composable
        override fun Content() {
            TextBase(
                textResId = R.string.camera_blocking_error_camera,
                style = Title22Style().style()
            )
            Spacer(modifier = Modifier.padding(bottom = 30.dp))

            TransparentStrokeButton(R.string.camera_blocking_error_camera) {

            }
        }
    }
}