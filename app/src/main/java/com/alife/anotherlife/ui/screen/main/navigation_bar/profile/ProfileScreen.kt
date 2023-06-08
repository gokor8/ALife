package com.alife.anotherlife.ui.screen.main.navigation_bar.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.modifier.BaseScrollFillMaxModifier
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.SnackBarWrapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.LceErrorProfileLoad
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.LceErrorProfileProvider
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileConstraintModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileConstraints
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileAction

class ProfileScreen(
    private val innerPadding: PaddingValues,
    override val navController: NavController
) : VMScreenLCE<ProfileViewModel>(BaseScrollFillMaxModifier) {

    @Composable
    override fun setupViewModel(): ProfileViewModel = hiltViewModel()

    override suspend fun onInit() {
        viewModel.reduce(ProfileAction.OnInit())
    }

    @Composable
    override fun Content(modifier: Modifier) {
        if (viewModel.getUIState().lceModel is LceErrorProfileProvider)
            LceErrorProfileLoad().LCEContent {
                viewModel.reduce(ProfileAction.OnInit())
            }
        else
            super.Content(modifier)
    }


    @Composable
    override fun SafeContent(modifier: Modifier) {
        val constraints = ProfileConstraintModel()

        val snackBarHostState = remember { SnackbarHostState() }

        Scaffold(
            contentWindowInsets = WindowInsets(bottom = innerPadding.calculateBottomPadding()),
            snackbarHost = { SnackbarHost(snackBarHostState) }
        ) { innerPadding ->

            ConstraintLayout(
                ProfileConstraints().markup(constraints),
                modifier = modifier
                    .padding(innerPadding)
                    .imePadding()
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                val fillState = viewModel.getUIState().contentFillState

                key(fillState) {
                    fillState.ContentFill(constraints = constraints)
                }
            }
        }

        var snackBarErrorEffect by remember {
            mutableStateOf<SnackBarWrapper?>(null)
        }.also { wrapper ->
            wrapper.value?.SnackBar(snackBarHostState)
        }

        LaunchedEffect(Unit) {
            viewModel.collectEffect(navController) { wrapper ->
                snackBarErrorEffect = wrapper
            }
        }
    }

    override suspend fun setupEventCollector() = Unit
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    //ProfileScreen().SetupContent()
}