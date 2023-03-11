package com.alife.anotherlife.ui.screen.registration.email.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.email.EmailAnnotation
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.domain.registration.usecase.email.BaseEmailUseCase
import javax.inject.Inject

class EmailRegValidationReducer @Inject constructor(
    @EmailAnnotation.EmailUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    saveRegUseCase: BaseEmailUseCase.Save
) : BaseValidationRegReducer.Abstract(uiStore, saveRegUseCase) {

    override suspend fun navigateNext() {
        uiStore.trySetEffect(RegistrationEffect.NavigateEmailCode())
    }
}