package com.alife.anotherlife.ui.screen.registration.email.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.email.EmailAnnotation
import com.alife.anotherlife.ui.screen.registration.base.chain.RegChainValidator
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.domain.registration.usecase.reg_log.email.save_read.BaseEmailUseCase
import javax.inject.Inject

class EmailRegistrationReducerBase @Inject constructor(
    @EmailAnnotation.EmailUIStore
    reducer: UIStore<RegistrationState, RegistrationEffect>,
    @EmailAnnotation.EmailChain
    chain: BaseRegTextChain,
    @EmailAnnotation.EmailValidation
    validationNameRegReducer: BaseValidationRegReducer,
    @EmailAnnotation.EmailTextInputChain
    onInputChain: RegChainValidator.BooleanValidator,
    readUseCase: BaseEmailUseCase.Read
) : BaseRegistrationReducer.WithInputChain(
    reducer,
    chain,
    validationNameRegReducer,
    readUseCase,
    onInputChain
) {

    override suspend fun onBackPress() {
        uiStore.setEffect(RegistrationEffect.NavigateBirthday())
    }
}