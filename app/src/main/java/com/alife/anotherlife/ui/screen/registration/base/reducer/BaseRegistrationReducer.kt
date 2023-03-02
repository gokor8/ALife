package com.alife.anotherlife.ui.screen.registration.base.reducer

import androidx.compose.ui.text.input.TextFieldValue
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.core.chain.ChainHandler

interface BaseRegistrationReducer {

    fun onTextInput(textFieldValue: TextFieldValue)

    fun onNextClick()


    abstract class Abstract(
        uiStore: UIStore<RegistrationState, RegistrationEffect>,
        private val chainValidator: BaseRegTextChain,
        private val validationRegReducer: BaseValidationRegReducer,
    ) : RegistrationReducer(uiStore), BaseRegistrationReducer {

        override fun onNextClick() {
            chainValidator.handle(
                uiStore.getState().textWithErrorModel.textFieldValue.text
            ).onChainResult(validationRegReducer)
        }
    }

    abstract class WithInputChain(
        uiStore: UIStore<RegistrationState, RegistrationEffect>,
        ChainValidator: BaseRegTextChain,
        validationRegReducer: BaseValidationRegReducer,
        private val inputTextChain: ChainHandler.Base<String, Boolean>,
    ) : Abstract(uiStore, ChainValidator, validationRegReducer) {
        override fun onTextInput(textFieldValue: TextFieldValue) {
            if (inputTextChain.handle(textFieldValue.text)) {
                super.onTextInput(textFieldValue)
            }
        }
    }
}