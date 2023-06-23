package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.BaseProfileReducer

interface ProfileAction : BaseMVIAction<BaseProfileReducer> {

    class OnInit : ProfileAction {
        override suspend fun onAction(reducer: BaseProfileReducer) {
            reducer.onInit()
        }
    }

    class Back : ProfileAction {
        override suspend fun onAction(reducer: BaseProfileReducer) {
            reducer.onBack()
        }
    }
}