package com.alife.anotherlife.ui.screen.main.navigation_bar.home.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.BaseHomeReducerBase

interface HomeAction : BaseMVIAction<BaseHomeReducerBase> {

    class Refresh : HomeAction {
        override suspend fun onAction(reducer: BaseHomeReducerBase) {
            reducer.onRefresh()
        }
    }

    class ChangePagerItemAction(private val position: Int) : HomeAction {

        override suspend fun onAction(reducer: BaseHomeReducerBase) {
            reducer.onChangePagerItem(position)
        }
    }
}