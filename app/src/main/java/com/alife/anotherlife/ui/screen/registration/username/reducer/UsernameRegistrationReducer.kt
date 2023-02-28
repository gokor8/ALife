package com.alife.anotherlife.ui.screen.registration.username.reducer

import androidx.compose.ui.text.input.TextFieldValue
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.name.NameAnnotation
import com.alife.anotherlife.di.ui.registration.username.UsernameAnnotation
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.username.chain.UsernameRegTextChain
import javax.inject.Inject

class UsernameRegistrationReducer @Inject constructor(
    @UsernameAnnotation.UsernameUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    @NameAnnotation.NameChain
    nameChainValidator: BaseRegTextChain,
    @UsernameAnnotation.UsernameValidation
    validationNameRegReducer: BaseValidationRegReducer,
    private val usernameRegTextChain: UsernameRegTextChain,
) : BaseRegistrationReducer.Abstract(uiStore, nameChainValidator, validationNameRegReducer) {

    override fun onTextInput(textFieldValue: TextFieldValue) {
        if (usernameRegTextChain.handle(textFieldValue.text)) {
            super.onTextInput(textFieldValue)
        }
    }
}