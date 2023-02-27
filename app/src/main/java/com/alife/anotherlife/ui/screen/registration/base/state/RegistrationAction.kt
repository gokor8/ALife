package com.alife.anotherlife.ui.screen.registration.base.state

import androidx.compose.ui.text.input.TextFieldValue
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import com.alife.core.mvi.MVI

interface RegistrationAction : MVI.Action {

    fun onAction(reducer: RegistrationReducer)


    class OnTextInput(private val textFieldValue: TextFieldValue) : RegistrationAction {

        override fun onAction(reducer: RegistrationReducer) {
            reducer.onTextInput(textFieldValue)
        }
    }

    class OnContinueClick : RegistrationAction {

        override fun onAction(reducer: RegistrationReducer) {
            reducer.onNextClick()
        }
    }
}