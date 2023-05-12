package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.button.TransparentStrokeButton
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title22Style
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BasePictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.BaseVideoScreenState

class ErrorPermissionScreenState : ScreenState.AbstractScreenState(Alignment.Center),
    BasePictureScreenState, BaseVideoScreenState {

    @Composable
    override fun SafeContent(viewModel: CreateAlifeViewModel) {
        val context = LocalContext.current

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            TextBase(
                textResId = R.string.camera_blocking_error_camera,
                textAlign = TextAlign.Center,
                style = Title22Style().style()
            )
            Spacer(modifier = Modifier.padding(bottom = 30.dp))

            TransparentStrokeButton(R.string.camera_blocking_error_camera) {
                context.startActivity(viewModel.settingsIntent)
            }
        }
    }
}