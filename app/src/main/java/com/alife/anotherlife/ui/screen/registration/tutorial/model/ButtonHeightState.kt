package com.alife.anotherlife.ui.screen.registration.tutorial.model

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.composable.text.style.FloatingButton18
import com.alife.anotherlife.theme.Shapes
import com.alife.anotherlife.ui.screen.registration.tutorial.TutorialViewModel
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialAction

abstract class ButtonHeightState(private val isVisible: Boolean) {

    @Composable
    fun BottomButton(
        viewModel: TutorialViewModel,
        modifier: Modifier
    ) {
        AnimatedVisibility(
            modifier = modifier.padding(24.dp).clip(Shapes.medium),
            visible = isVisible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            FloatingButton18(R.string.continue_next) {
                viewModel.reduce(TutorialAction.OnContinueClick())
            }
        }
    }

    class Hide : ButtonHeightState(false)

    class Button : ButtonHeightState(true)
}