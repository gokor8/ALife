package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
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
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi

class CreateAlifeScreen(
    override val navController: NavController,
) : VMScreen<CreateAlifeViewModel>(ImeModifier()) {

    @Composable
    override fun setupViewModel(): CreateAlifeViewModel = hiltViewModel()

    @OptIn(
        ExperimentalPermissionsApi::class,
        ExperimentalAnimationApi::class,
        ExperimentalFoundationApi::class
    )
    @Composable
    override fun Content(modifier: Modifier) {
        val cameraPermission = viewModel.cameraPermission.requirePermission { permissionState ->
            when (permissionState) {
                is PermissionStatus.Success -> {
                    viewModel.reduce(CreateAlifeAction.PermissionGrantedAction())
                }
                is PermissionStatus.Fatal -> {
                    viewModel.reduce(CreateAlifeAction.PermissionFatalAction())
                }
            }
        }

        val state = viewModel.getUIState()

        AnimatedContent(targetState = state.screenState) { screenState ->
            screenState.Content(cameraPermission, viewModel, modifier)
        }

        Column(
            horizontalAlignment = CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            TextBase(
                textResId = R.string.horizontal_short_logo,
                style = Title28Style().style(),
                modifier = Modifier.padding(top = 22.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            CameraActionsComposable(
                pagerState = state.pagerState,
                pagerItems = state.pagerItems,
                state = state,
                viewModel = viewModel
            )
        }
    }
}