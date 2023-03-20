package com.alife.anotherlife.ui.screen.registration.tutorial.model

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.ui.screen.registration.tutorial.TutorialViewModel
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialAction

abstract class ButtonHeightState(private val isVisible: Boolean) {

    @Composable
    fun BottomButton(viewModel: TutorialViewModel) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Button18(
                textResId = R.string.continue_next,
                modifier = Modifier.padding(24.dp)
            ) {
                viewModel.reduce(
                    TutorialAction.OnContinueClick()
                )
            }
        }
    }

    class Hide : ButtonHeightState(false)

    class Button : ButtonHeightState(true)
}