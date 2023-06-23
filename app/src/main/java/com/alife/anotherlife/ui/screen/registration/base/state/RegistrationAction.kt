package com.alife.anotherlife.ui.screen.registration.base.state

import androidx.compose.ui.text.input.TextFieldValue
import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducerBase
import com.alife.core.mvi.MVI

interface RegistrationAction : BaseMVIAction<RegistrationReducerBase> {

    class OnBackPress : RegistrationAction {

        override suspend fun onAction(reducer: RegistrationReducerBase) {
            reducer.onBackPress()
        }
    }

    class OnInit : RegistrationAction {

        override suspend fun onAction(reducer: RegistrationReducerBase) {
            reducer.onInit()
        }
    }

    class OnTextInput(private val textFieldValue: TextFieldValue) : RegistrationAction {

        override suspend fun onAction(reducer: RegistrationReducerBase) {
            reducer.onTextInput(textFieldValue)
        }
    }

    class OnContinueClick : RegistrationAction {

        override suspend fun onAction(reducer: RegistrationReducerBase) {
            reducer.onNextClick()
        }
    }
}