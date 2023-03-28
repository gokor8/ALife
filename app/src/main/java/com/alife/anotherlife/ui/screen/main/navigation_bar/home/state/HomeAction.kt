package com.alife.anotherlife.ui.screen.main.navigation_bar.home.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.BaseHomeReducer

interface HomeAction : BaseMVIAction<BaseHomeReducer> {

    class ChangePagerItemAction(private val position: Int) : HomeAction {

        override suspend fun onAction(reducer: BaseHomeReducer) {
            reducer.onChangePagerItem(position)
        }
    }
}