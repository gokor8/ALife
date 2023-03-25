package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.customTabIndicatorOffset
import com.alife.anotherlife.core.composable.modifier.ImeModifier
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.theme.Shapes
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.state.HomeAction
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class HomeScreen(
    override val navController: NavController,
) : VMScreen<HomeViewModel>(ImeModifier()) {

    @Composable
    override fun setupViewModel(): HomeViewModel = hiltViewModel()

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    override fun Content(modifier: Modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            TextBase(
                textResId = R.string.horizontal_short_small_logo,
                style = Title28Style().style()
            )
            Spacer(modifier = Modifier.padding(bottom = 16.dp))

            val state = viewModel.getUIState()
            val pagerState = state.pagerState

            TabRow(
                selectedTabIndex = pagerState.currentPage,
                divider = {},
                indicator = {},
                modifier = Modifier.width(156.dp)
            ) {
                state.pagerScreens.forEach {
                    it.TabContent(pagerState.currentPage) { index ->
                        viewModel.reduce(HomeAction.ChangePagerItemAction(index))
                    }
                }
            }

            HorizontalPager(
                count = state.pagerScreens.size,
                state = pagerState
            ) {
                state.pagerScreens[it].model.Screen()
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController()).SetupContent()
}