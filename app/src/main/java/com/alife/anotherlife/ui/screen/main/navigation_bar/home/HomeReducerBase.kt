package com.alife.anotherlife.ui.screen.main.navigation_bar.home

import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeState
import javax.inject.Inject

class HomeReducerBase @Inject constructor(
    override val uiStore: UIStore<HomeState, HomeEffect>,
) : BaseHomeReducerBase, AbstractVMReducer<HomeState, HomeEffect>() {

    override suspend fun onChangePagerItem(position: Int) {
        setEffect(HomeEffect.ChangePagerItemEffect(position))
    }
}