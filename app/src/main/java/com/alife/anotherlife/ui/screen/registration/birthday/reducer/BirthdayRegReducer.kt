package com.alife.anotherlife.ui.screen.registration.birthday.reducer

import androidx.compose.ui.text.input.TextFieldValue
import androidx.core.text.isDigitsOnly
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.birthday.BirthdayAnnotation
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.usecase.birthday.BaseBirthdayUseCase
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity
import javax.inject.Inject

class BirthdayRegReducer @Inject constructor(
    @BirthdayAnnotation.BirthdayUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    @BirthdayAnnotation.BirthdayChain
    nameChainValidator: BaseRegTextChain,
    @BirthdayAnnotation.BirthdayValidation
    validationNameRegReducer: BaseValidationRegReducer,
    birthdayReadRegUseCase: BaseBirthdayUseCase.Read
) : BaseRegistrationReducer.Abstract<BirthdayRegEntity>(
    uiStore,
    nameChainValidator,
    validationNameRegReducer,
    birthdayReadRegUseCase
) {

    override suspend fun onBackPress() {
        uiStore.setEffect(RegistrationEffect.NavigateUsername())
    }

    override fun onTextInput(textFieldValue: TextFieldValue) {
        if (textFieldValue.text.isDigitsOnly()) {
            super.onTextInput(textFieldValue)
        }
    }
}