package com.alife.anotherlife.ui.screen.main.navigation_bar.home

import android.util.Log
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeState
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.Reusable
import javax.inject.Inject

class HomeReducer @Inject constructor(
    override val uiStore: UIStore<HomeState, HomeEffect>,
) : BaseHomeReducerBase, AbstractVMReducer<HomeState, HomeEffect>() {

    override suspend fun onChangePagerItem(position: Int) {
        setEffect(HomeEffect.ChangePagerItemEffect(position))
    }

    override suspend fun onRefresh() {

    }

    override suspend fun onTabsVisible() {
        onTabVisibility(true)
    }

    override suspend fun onTabsInvisible() {
        onTabVisibility(false)
    }

    @OptIn(ExperimentalPagerApi::class)
    override suspend fun onTabVisibility(isVisible: Boolean) {
        Log.d("Visibility 1", "${getState().isTabsVisible}")

        setState { copy(isTabsVisible = isVisible) }
    }
}