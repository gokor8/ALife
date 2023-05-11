package com.alife.anotherlife.ui.screen.registration.tutorial

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alife.anotherlife.core.composable.modifier.SystemPaddingModifier
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.alife.anotherlife.theme.AnotherLifeTheme
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialAction

class TutorialScreen(
    override val navController: NavController
) : VMScreen<TutorialViewModel>(SystemPaddingModifier) {

    @Composable
    override fun setupViewModel(): TutorialViewModel = hiltViewModel()

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    override fun Content(modifier: Modifier) {
        Column(modifier) {
            val state = viewModel.getUIState()

            val pagerState = rememberPagerState()

            HorizontalPager(
                count = state.screenTutorsList.size,
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { index ->
                state.screenTutorsList[index].SetupContent()
            }

            LaunchedEffect(pagerState.currentPage) {
                viewModel.reduce(
                    TutorialAction.OnScreenChangeAction(pagerState.currentPage)
                )
            }

            state.buttonHeightState.BottomButton(viewModel = viewModel)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 44.dp)
            ) {
                repeat(state.screenTutorsList.size) { index ->
                    val animationColor by animateColorAsState(
                        if (pagerState.currentPage == index) Color.Gray else Color.LightGray
                    )

                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(78.dp, 8.dp)
                            .background(
                                animationColor,
                                MaterialTheme.shapes.medium
                            )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TutorialScreenPreview() {
    AnotherLifeTheme {
        TutorialScreen(rememberNavController()).SetupContent()
    }
}