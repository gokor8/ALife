package com.alife.anotherlife.ui.screen.registration.name.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.name.NameAnnotation
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.name.chain.InputRegTextChain
import com.alife.domain.registration.usecase.name.BaseNameUseCase
import javax.inject.Inject

class NameRegistrationReducer @Inject constructor(
    @NameAnnotation.NameUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    @NameAnnotation.NameChain
    nameChainValidator: BaseRegTextChain,
    @NameAnnotation.NameValidation
    validationNameRegReducer: BaseValidationRegReducer,
    textInputChainValidator: InputRegTextChain,
    readNameUseCase: BaseNameUseCase.Read,
) : BaseRegistrationReducer.WithInputChain(
    uiStore,
    nameChainValidator,
    validationNameRegReducer,
    readNameUseCase,
    textInputChainValidator
) {

    override suspend fun onBackPress() {
        uiStore.setEffect(RegistrationEffect.NavigateLoginBack())
    }
}