package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.mvi_extensions.DefaultViewModel
import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState

abstract class AbstractHomeChildViewModel(
    override val reducerVM: BaseHomeChildReducer
) : ViewModelLCE<BaseHomeChildReducer, HomeChildAction, HomeChildState, HomeChildEffect>(reducerVM) {

    override suspend fun onAction(action: HomeChildAction) {
        var currentAction = action

        if(action is HomeChildAction.OnInit)
            currentAction = HomeChildAction.OnInitScoped(viewModelScope)

        super.onAction(currentAction)
    }

    suspend fun collectEffect(navController: NavController, onSnackBar: suspend () -> Unit) {
        reducerVM.getEffectCollector().collect { effect ->
            when(effect) {
                is HomeChildEffect.RequireInit -> reduce(HomeChildAction.OnInit())
                is HomeChildEffect.SnackBarPagingError -> onSnackBar()
                else -> onEffect(navController, effect)
            }
        }
    }
}