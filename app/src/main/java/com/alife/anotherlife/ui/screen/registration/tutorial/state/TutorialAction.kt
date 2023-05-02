package com.alife.anotherlife.ui.screen.registration.tutorial.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.registration.tutorial.BaseTutorialReducerBase

interface TutorialAction : BaseMVIAction<BaseTutorialReducerBase> {

    class OnScreenChangeAction(private val index: Int) : TutorialAction {
        override suspend fun onAction(reducer: BaseTutorialReducerBase) {
            reducer.onScreenChanged(index)
        }
    }

    class OnContinueClick() : TutorialAction {
        override suspend fun onAction(reducer: BaseTutorialReducerBase) {
            reducer.onContinue()
        }
    }
}