package com.alife.anotherlife.ui.screen.registration.birthday.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.birthday.BirthdayAnnotation
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.domain.registration.usecase.birthday.BaseBirthdayUseCase
import com.alife.domain.registration.usecase.username.BaseUsernameUseCase
import javax.inject.Inject

class BirthdayValidationRegReducerBase @Inject constructor(
    @BirthdayAnnotation.BirthdayUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    saveBirthdayUseCase: BaseBirthdayUseCase.Save,
) : BaseValidationRegReducer.Abstract(uiStore, saveBirthdayUseCase) {

    override suspend fun navigateNext() {
        uiStore.trySetEffect(RegistrationEffect.NavigateEmail())
    }
}