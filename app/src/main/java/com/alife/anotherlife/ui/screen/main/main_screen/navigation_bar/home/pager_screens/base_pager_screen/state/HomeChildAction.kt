package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.BaseHomeChildReducer

interface HomeChildAction : BaseMVIAction<BaseHomeChildReducer> {

    class OnTakeALife : HomeChildAction {

        override suspend fun onAction(reducer: BaseHomeChildReducer) {
            reducer.onTakeALife()
        }
    }
}