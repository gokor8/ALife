package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState

class ErrorCameraScreenState : ScreenState {
    
    @Composable
    override fun Content(viewModel: CreateAlifeViewModel, modifier: Modifier) {
        Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
            TextBase(textResId = R.string.camera_blocking_error_fatal)
        }
    }
}