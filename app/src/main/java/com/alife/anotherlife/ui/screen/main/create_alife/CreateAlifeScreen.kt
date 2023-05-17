package com.alife.anotherlife.ui.screen.main.create_alife

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.modifier.OnlyImeModifier
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraActionsComposable
import com.alife.anotherlife.ui.screen.main.create_alife.state.AbstractDialogErrorEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.BaseDialogErrorEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.BaseSnackBarEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import kotlinx.coroutines.launch

class CreateAlifeScreen(
    override val navController: NavController,
) : VMScreenLCE<CreateAlifeViewModel>(OnlyImeModifier()) {

    @Composable
    override fun setupViewModel(): CreateAlifeViewModel = hiltViewModel()

    @OptIn(
        ExperimentalAnimationApi::class,
        ExperimentalFoundationApi::class,
    )
    @Composable
    override fun SafeContent(modifier: Modifier) {
        val context = LocalContext.current
        val state = viewModel.getUIState()

        Box {
            AnimatedContent(state.currentScreenPager().screenState) { screenState ->
                screenState.Content(viewModel, modifier)
            }

            val pagerState = rememberPagerState(state.currentPage)

            key(pagerState.currentPage) {
                viewModel.reduce(CreateAlifeAction.ChangeCurrentPage(pagerState.currentPage))
            }

            CameraActionsComposable(
                pagerState = pagerState,
                state = state,
                pagerItems = state.pagerContainer.getPagerItems(),
                viewModel = viewModel,
                modifier = modifier.align(Alignment.BottomCenter)
            )

            val snackBarEffect = remember {
                mutableStateOf<BaseSnackBarEffect>(CreateAlifeEffect.EmptySnackError())
            }

            var dialogError by remember {
                mutableStateOf<BaseDialogErrorEffect>(CreateAlifeEffect.EmptyDialogError())
            }

            LaunchedEffect(Unit) {
                viewModel.collectEffect(
                    navController,
                    pagerState,
                    onSnackBarEffect = { effect -> effect.showSnackBar(snackBarEffect) },
                    onDialogError = { effect -> dialogError = effect }
                )
            }

            // TODO maybe delete?
            Log.d("Aboba Dialog", "$dialogError")
            dialogError.DialogErrorContent {
                context.startActivity(state.settingsIntent)
            }

            snackBarEffect.value.ShowSnackBar(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .navigationBarsPadding()
                    .align(Alignment.BottomCenter)
            )
        }
    }

    override suspend fun setupEventCollector() = Unit
}