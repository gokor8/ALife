package com.alife.anotherlife.ui.screen.registration.tutorial.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.registration.tutorial.BaseTutorialReducer

interface TutorialAction : BaseMVIAction<BaseTutorialReducer> {

    class OnScreenChangeAction(private val index: Int) : TutorialAction {
        override fun onAction(reducer: BaseTutorialReducer) {
            reducer.onScreenChanged(index)
        }
    }

    class OnContinueClick() : TutorialAction {
        override fun onAction(reducer: BaseTutorialReducer) {
            reducer.onContinue()
        }
    }
}