package com.alife.anotherlife.ui.screen.registration.base.state

import androidx.compose.ui.text.input.TextFieldValue
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import com.alife.core.mvi.MVI

interface RegistrationAction : MVI.Action {

    suspend fun onAction(reducer: RegistrationReducer)

    class OnBackPress : RegistrationAction {

        override suspend fun onAction(reducer: RegistrationReducer) {
            reducer.onBackPress()
        }
    }

    class OnInit : RegistrationAction {

        override suspend fun onAction(reducer: RegistrationReducer) {
            reducer.onInit()
        }
    }

    class OnTextInput(private val textFieldValue: TextFieldValue) : RegistrationAction {

        override suspend fun onAction(reducer: RegistrationReducer) {
            reducer.onTextInput(textFieldValue)
        }
    }

    class OnContinueClick : RegistrationAction {

        override suspend fun onAction(reducer: RegistrationReducer) {
            reducer.onNextClick()
        }
    }
}