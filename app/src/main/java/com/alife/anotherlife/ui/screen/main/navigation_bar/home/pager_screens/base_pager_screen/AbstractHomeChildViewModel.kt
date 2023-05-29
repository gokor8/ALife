package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import androidx.lifecycle.viewModelScope
import com.alife.anotherlife.core.composable.mvi_extensions.DefaultViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState

abstract class AbstractHomeChildViewModel(
    override val reducerVM: AbstractHomeChildReducerBase
) : DefaultViewModel<AbstractHomeChildReducerBase, HomeChildAction, HomeChildState, HomeChildEffect>(reducerVM) {

    override suspend fun onAction(action: HomeChildAction) {
        var currentAction = action

        if(action is HomeChildAction.OnInit)
            currentAction = HomeChildAction.OnInitScoped(viewModelScope)

        super.onAction(currentAction)
    }
}