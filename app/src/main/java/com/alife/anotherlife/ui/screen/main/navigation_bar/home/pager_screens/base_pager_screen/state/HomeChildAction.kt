package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildReducerBase
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope

interface HomeChildAction : BaseMVIAction<AbstractHomeChildReducerBase> {

    class OnInitScoped(private val viewModelScope: CoroutineScope) : HomeChildAction {
        override suspend fun onAction(reducer: AbstractHomeChildReducerBase) {
            reducer.onInit(viewModelScope)
        }
    }

    class OnInit : HomeChildAction {
        override suspend fun onAction(reducer: AbstractHomeChildReducerBase) {}
    }

    class OnTakeALife : HomeChildAction {

        override suspend fun onAction(reducer: AbstractHomeChildReducerBase) {
            reducer.onTakeALife()
        }
    }
}