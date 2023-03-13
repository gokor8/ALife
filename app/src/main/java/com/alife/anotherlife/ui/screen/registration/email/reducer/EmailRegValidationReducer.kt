package com.alife.anotherlife.ui.screen.registration.email.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.email.EmailAnnotation
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.email.send_reg_data.BaseSendRegDataUseCase
import com.alife.domain.registration.usecase.email.save_read.BaseEmailUseCase
import javax.inject.Inject

class EmailRegValidationReducer @Inject constructor(
    @EmailAnnotation.EmailUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    saveRegUseCase: BaseEmailUseCase.Save,
    private val sendRegDataUseCase: BaseSendRegDataUseCase,
) : BaseValidationRegReducer.Abstract(uiStore, saveRegUseCase) {

    override suspend fun navigateNext() {
        when (sendRegDataUseCase.sendRegData()) {
            is UseCaseResult.BaseSuccess -> {
                uiStore.trySetEffect(RegistrationEffect.NavigateEmailCode())
            }
            else -> { /* Map and set Error */ }
        }
    }
}