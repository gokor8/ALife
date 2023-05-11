package com.alife.anotherlife.ui.screen.main.navigation_bar.home

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeState

interface BaseHomeReducerBase : BaseVMReducer<HomeState, HomeEffect> {
    suspend fun onChangePagerItem(position: Int)
}