package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.button.TransparentStrokeButton
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title22Style
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel

class ErrorPermissionScreenState : ScreenState.AbstractScreenState(Alignment.Center) {

    @Composable
    override fun SafeContent(viewModel: CreateAlifeViewModel, ) {
        val context = LocalContext.current
        val state = viewModel.getUIState()

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextBase(
                textResId = R.string.camera_blocking_error_camera,
                style = Title22Style().style()
            )
            Spacer(modifier = Modifier.padding(bottom = 30.dp))

            TransparentStrokeButton(R.string.camera_blocking_error_camera) {
                context.startActivity(state.settingsIntent)
            }
        }
    }
}