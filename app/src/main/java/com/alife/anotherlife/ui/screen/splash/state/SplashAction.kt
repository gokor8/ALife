package com.alife.anotherlife.ui.screen.splash.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.splash.BaseSplashReducer

interface SplashAction : BaseMVIAction<BaseSplashReducer> {

    class Init : SplashAction {
        override suspend fun onAction(reducer: BaseSplashReducer) {
            reducer.onInit()
        }
    }
}