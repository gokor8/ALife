package com.alife.anotherlife.ui.screen.registration.birthday.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.birthday.BirthdayAnnotation
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.domain.registration.usecase.birthday.BaseBirthdayUseCase
import com.alife.domain.registration.usecase.username.BaseUsernameUseCase
import javax.inject.Inject

class BirthdayValidationRegReducer @Inject constructor(
    @BirthdayAnnotation.BirthdayUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    private val saveBirthdayUseCase: BaseBirthdayUseCase.Save,
) : BaseValidationRegReducer.Abstract(uiStore) {

    override suspend fun navigateNext() {
        saveBirthdayUseCase.saveData(getState().textWithErrorModel.getCurrentText())
        uiStore.trySetEffect(RegistrationEffect.NavigateEmail())
    }
}