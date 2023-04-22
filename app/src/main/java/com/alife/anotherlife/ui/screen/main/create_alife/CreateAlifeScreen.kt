package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.modifier.ImeModifier
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraActionsComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CameraPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.VideoCameraPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi

class CreateAlifeScreen(
    override val navController: NavController,
) : VMScreen<CreateAlifeViewModel>(ImeModifier()) {

    @Composable
    override fun setupViewModel(): CreateAlifeViewModel = hiltViewModel()

    @OptIn(ExperimentalAnimationApi::class, ExperimentalFoundationApi::class)
    @Composable
    override fun Content(modifier: Modifier) {
        val state = viewModel.getUIState()

        AnimatedContent(targetState = state.currentScreenState()) { screenState ->
            screenState.Content(viewModel, modifier)
        }

        Column(
            horizontalAlignment = CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            val pagerItems = state.pagerItems

            TextBase(
                textResId = R.string.horizontal_short_logo,
                style = Title28Style().style(),
                modifier = Modifier.padding(top = 22.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            CameraActionsComposable(
                pagerState = state.pagerState,
                pagerItems = state.pagerItems.getPagerItems(),
                state = state,
                viewModel = viewModel
            )
        }
    }
}