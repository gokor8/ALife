package com.alife.anotherlife.ui.screen.registration.tutorial

import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.tutorial.model.ButtonHeightState
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialEffect
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialState
import javax.inject.Inject

class TutorialReducerBase @Inject constructor(
    override val uiStore: UIStore<TutorialState, TutorialEffect>
) : AbstractVMReducer<TutorialState, TutorialEffect>(), BaseTutorialReducerBase {

    override fun onScreenChanged(index: Int) {
        setState {
            copy(
                buttonHeightState = if (index + 1 == screenTutorsList.size)
                    ButtonHeightState.Button()
                else
                    ButtonHeightState.Hide()
            )
        }
    }

    override suspend fun onContinue() {
        setEffect(TutorialEffect.NavigateMainScreen())
    }
}