package com.alife.anotherlife.ui.screen.registration.base.reducer

import androidx.compose.ui.text.input.TextFieldValue
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain

interface BaseRegistrationReducer {

    fun onTextInput(textFieldValue: TextFieldValue)

    fun onNextClick()


    abstract class Abstract(
        uiStore: UIStore<RegistrationState, RegistrationEffect>,
        private val nameChainValidator: BaseRegTextChain,
        private val validationNameRegReducer: BaseValidationRegReducer
    ) : RegistrationReducer(uiStore), BaseRegistrationReducer {

        override fun onNextClick() {
            nameChainValidator.handle(
                uiStore.getState().textWithErrorModel.textFieldValue.text
            ).onChainResult(validationNameRegReducer)
        }
    }
}