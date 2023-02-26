package com.alife.anotherlife.ui.screen.registration.birthday.reducer

import androidx.core.text.isDigitsOnly
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.birthday.BirthdayAnnotation
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import javax.inject.Inject

class BirthdayRegReducer @Inject constructor(
    @BirthdayAnnotation.BirthdayUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    @BirthdayAnnotation.BirthdayChain
    nameChainValidator: BaseRegTextChain,
    @BirthdayAnnotation.BirthdayValidation
    validationNameRegReducer: BaseValidationRegReducer,
) : BaseRegistrationReducer.Abstract(uiStore, nameChainValidator, validationNameRegReducer) {

    override fun onTextInput(text: String) {
        if (text.isDigitsOnly()) {
            super.onTextInput(text)
        }
    }
}