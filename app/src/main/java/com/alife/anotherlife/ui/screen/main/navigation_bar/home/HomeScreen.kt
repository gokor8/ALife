package com.alife.anotherlife.ui.screen.main.navigation_bar.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.brush.verticalPrimaryGradient
import com.alife.anotherlife.core.composable.customTabIndicatorOffset
import com.alife.anotherlife.core.composable.modifier.NoMaxSizeSystemPaddingModifier
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeAction
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

class HomeScreen(
    override val navController: NavController,
) : VMScreen<HomeViewModel>(NoMaxSizeSystemPaddingModifier) {

    @Composable
    override fun setupViewModel(): HomeViewModel = hiltViewModel()

    @OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
    @Composable
    override fun Content(modifier: Modifier) {
        val state = viewModel.getUIState()
        val pagerScreens = state.pagerScreens
        val pagerState = state.pagerState

        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            HorizontalPager(
                count = pagerScreens.size,
                state = pagerState
            ) {
                pagerScreens[it].model.screen(navController, it == pagerState.currentPage)
                    .SetupContent()
            }

            val gradient = verticalPrimaryGradient()
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .align(Alignment.TopCenter)
            ) { drawRect(brush = gradient, size = size) }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.fillMaxWidth()
            ) {
                TextBase(
                    textResId = R.string.horizontal_short_small_logo,
                    style = Title28Style().style()
                )
                Spacer(modifier = Modifier.padding(bottom = 16.dp))

                AnimatedVisibility(visible = state.isTabsVisible) {
                    TabRow(
                        selectedTabIndex = pagerState.currentPage,
                        divider = {},
                        indicator = { tabPositions ->
                            TabRowDefaults.Indicator(
                                height = 1.dp,
                                modifier = Modifier.customTabIndicatorOffset(
                                    currentTabPosition = tabPositions[pagerState.currentPage],
                                    tabWidth = pagerScreens[pagerState.currentPage].model.textWidth()
                                )
                            )
                        },
                        containerColor = Color.Transparent,
                        modifier = Modifier.width(156.dp)
                    ) {
                        pagerScreens.forEach {
                            it.TabContent(pagerState.currentPage) { index ->
                                viewModel.reduce(HomeAction.ChangePagerItemAction(index))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController()).SetupContent()
}