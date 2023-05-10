package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.modifier.OnlyImeModifier
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraActionsComposable

class CreateAlifeScreen(
    override val navController: NavController,
) : VMScreenLCE<CreateAlifeViewModel>(OnlyImeModifier()) {

    @Composable
    override fun setupViewModel(): CreateAlifeViewModel = hiltViewModel()

    @OptIn(ExperimentalAnimationApi::class, ExperimentalFoundationApi::class)
    @Composable
    override fun SafeContent(modifier: Modifier) {
        val state = viewModel.getUIState()

        Box {
            AnimatedContent(state.currentScreenPager().screenState) { screenState ->
                screenState.Content(viewModel, modifier)
            }

            CameraActionsComposable(
                pagerState = state.pagerState,
                state = state,
                pagerItems = state.pagerContainer.getPagerItems(),
                viewModel = viewModel,
                modifier = modifier.align(Alignment.BottomCenter)
            )
        }
    }
}