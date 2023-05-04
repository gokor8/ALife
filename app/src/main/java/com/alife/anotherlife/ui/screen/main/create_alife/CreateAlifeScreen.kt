package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.modifier.OnlyImeModifier
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraActionsComposable

class CreateAlifeScreen(
    override val navController: NavController,
) : VMScreen<CreateAlifeViewModel>(OnlyImeModifier()) {

    @Composable
    override fun setupViewModel(): CreateAlifeViewModel = hiltViewModel()

    @OptIn(ExperimentalAnimationApi::class, ExperimentalFoundationApi::class)
    @Composable
    override fun Content(modifier: Modifier) {
        val state = viewModel.getUIState()

        state.blockingScreen?.Content(viewModel, modifier) ?: kotlin.run {
            AnimatedContent(targetState = state.currentContainerState().screenState) { screenState ->
                screenState.Content(viewModel, modifier)
            }

            Column(
                horizontalAlignment = CenterHorizontally,
                modifier = modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.weight(1f))

                CameraActionsComposable(
                    pagerState = state.pagerState,
                    pagerItems = state.pagerContainer.getPagerItems(),
                    state = state,
                    viewModel = viewModel
                )
            }
        }
    }
}