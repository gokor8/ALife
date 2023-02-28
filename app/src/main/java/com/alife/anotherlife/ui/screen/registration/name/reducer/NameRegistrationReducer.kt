package com.alife.anotherlife.ui.screen.registration.name.reducer

import androidx.compose.ui.text.input.TextFieldValue
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.name.NameAnnotation
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.name.chain.NameRegTextChain
import javax.inject.Inject

class NameRegistrationReducer @Inject constructor(
    @NameAnnotation.NameUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    @NameAnnotation.NameChain
    nameChainValidator: BaseRegTextChain,
    @NameAnnotation.NameValidation
    validationNameRegReducer: BaseValidationRegReducer,
    private val textInputChainValidator: NameRegTextChain,
) : BaseRegistrationReducer.Abstract(uiStore, nameChainValidator, validationNameRegReducer) {

    override fun onTextInput(textFieldValue: TextFieldValue) {
        if (textInputChainValidator.handle(textFieldValue.text)) {
            super.onTextInput(textFieldValue)
        }
    }
}