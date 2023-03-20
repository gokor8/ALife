package com.alife.anotherlife.ui.screen.registration.tutorial

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.tutorial.model.ButtonHeightState
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialEffect
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialState
import javax.inject.Inject

class TutorialReducer @Inject constructor(
    override val uiStore: UIStore<TutorialState, TutorialEffect>
) : BaseVMReducer<TutorialState, TutorialEffect>(), BaseTutorialReducer {

    override fun onScreenChanged(index: Int) {
        setState {
            copy(
                buttonHeightState = if (index == screenTutorsList.size)
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