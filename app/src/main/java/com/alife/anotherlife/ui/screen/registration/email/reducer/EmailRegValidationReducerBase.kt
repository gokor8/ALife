package com.alife.anotherlife.ui.screen.registration.email.reducer

import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.email.EmailAnnotation
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.email.send_reg_data.BaseSendRegDataUseCase
import com.alife.domain.registration.usecase.email.save_read.BaseEmailUseCase
import com.google.android.gms.common.util.concurrent.HandlerExecutor
import javax.inject.Inject

class EmailRegValidationReducerBase @Inject constructor(
    @EmailAnnotation.EmailUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    saveRegUseCase: BaseEmailUseCase.Save,
    private val sendRegDataUseCase: BaseSendRegDataUseCase,
) : BaseValidationRegReducer.Abstract(uiStore, saveRegUseCase) {

    override suspend fun navigateNext() {
        setState { copy(lceModel = LCELoading) }

        execute {
            uiStore.trySetEffect(RegistrationEffect.DialogError(R.string.error_send_email))
        }.handle {
            sendRegDataUseCase.sendRegData()
            uiStore.trySetEffect(RegistrationEffect.NavigateEmailCode())
        }

        setState { copy(lceModel = LCEContent) }
    }
}