package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import androidx.paging.CombinedLoadStates
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import kotlinx.coroutines.CoroutineScope

interface BaseHomeChildReducer : BaseVMReducer<HomeChildState, HomeChildEffect> {

    suspend fun onInit(viewModelScoped: CoroutineScope)

    suspend fun onPagingLoadState(loadStates: CombinedLoadStates)

    suspend fun onTakeALife()

    suspend fun onScrollPosition(isScrolledUp: Boolean)
}