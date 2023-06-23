package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.ui.state.lce.LCEModel

class LCEErrorCamera : LCEModel {

    @Composable
    override fun LCEContent(modifier: Modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 60.dp),
            Alignment.Center
        ) {
            TextBase(
                textResId = R.string.camera_blocking_error_fatal,
                textAlign = TextAlign.Center
            )
        }
    }
}