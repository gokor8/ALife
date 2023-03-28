package com.alife.anotherlife.ui.screen.main.navigation_bar.home

import com.alife.anotherlife.core.ui.reducer.VMReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeState

interface BaseHomeReducer : VMReducer<HomeState, HomeEffect> {
    suspend fun onChangePagerItem(position: Int)
}