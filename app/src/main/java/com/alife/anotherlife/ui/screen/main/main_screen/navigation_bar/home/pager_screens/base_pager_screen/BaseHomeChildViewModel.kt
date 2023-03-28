package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen

import com.alife.anotherlife.core.composable.mvi_extensions.DefaultViewModel
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState

abstract class BaseHomeChildViewModel(
    override val reducerVM: BaseHomeChildReducer
) : DefaultViewModel<BaseHomeChildReducer, HomeChildAction, HomeChildState, HomeChildEffect>(reducerVM)