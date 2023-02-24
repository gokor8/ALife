package com.alife.anotherlife.ui.screen.registration.base.state

import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import com.alife.core.mvi.MVI

interface RegistrationAction : MVI.Action {

    fun onAction(reducer: RegistrationReducer)


    class OnTextInput(private val text: String) : RegistrationAction {

        override fun onAction(reducer: RegistrationReducer) {
            reducer.onTextInput(text)
        }
    }

    class OnContinueClick : RegistrationAction {

        override fun onAction(reducer: RegistrationReducer) {
            reducer.onNextClick()
        }
    }
}