package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildReducerBase

interface HomeChildAction : BaseMVIAction<AbstractHomeChildReducerBase> {

    class OnInit : HomeChildAction {

        override suspend fun onAction(reducer: AbstractHomeChildReducerBase) {
            reducer.onInit()
        }
    }
    class OnTakeALife : HomeChildAction {

        override suspend fun onAction(reducer: AbstractHomeChildReducerBase) {
            reducer.onTakeALife()
        }
    }
}