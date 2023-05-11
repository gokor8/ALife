package com.alife.anotherlife.ui.screen.main.navigation_bar.home

import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.mvi_extensions.DefaultViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeState
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    override val reducerVM: HomeReducerBase
) : DefaultViewModel<BaseHomeReducerBase, HomeAction, HomeState, HomeEffect>(reducerVM) {

    @OptIn(ExperimentalPagerApi::class)
    override suspend fun onEffect(navController: NavController, effect: HomeEffect) {
        super.onEffect(navController, effect)
        when(effect) {
            is HomeEffect.ChangePagerItemEffect -> {
                reducerVM.getState().pagerState.animateScrollToPage(effect.position)
            }
        }
    }
}