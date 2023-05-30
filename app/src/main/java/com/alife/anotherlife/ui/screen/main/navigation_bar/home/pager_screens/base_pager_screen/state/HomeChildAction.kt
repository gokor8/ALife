package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state

import androidx.paging.CombinedLoadStates
import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildReducerBase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.BaseHomeChildReducer
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope

interface HomeChildAction : BaseMVIAction<BaseHomeChildReducer> {

    class OnInitScoped(private val viewModelScope: CoroutineScope) : HomeChildAction {
        override suspend fun onAction(reducer: BaseHomeChildReducer) {
            reducer.onInit(viewModelScope)
        }
    }

    class OnInit : HomeChildAction {
        override suspend fun onAction(reducer: BaseHomeChildReducer) {}
    }

    class OnPagingLoadState(private val loadStates: CombinedLoadStates) : HomeChildAction {
        override suspend fun onAction(reducer: BaseHomeChildReducer) {
            reducer.onPagingLoadState(loadStates)
        }
    }

    class OnTakeALife : HomeChildAction {

        override suspend fun onAction(reducer: BaseHomeChildReducer) {
            reducer.onTakeALife()
        }
    }
}