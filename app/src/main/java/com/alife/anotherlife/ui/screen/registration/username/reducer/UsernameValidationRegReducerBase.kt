package com.alife.anotherlife.ui.screen.registration.username.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.username.UsernameAnnotation
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.domain.registration.usecase.name.BaseNameUseCase
import com.alife.domain.registration.usecase.username.BaseUsernameUseCase
import javax.inject.Inject

class UsernameValidationRegReducerBase @Inject constructor(
    @UsernameAnnotation.UsernameUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    saveUsernameUseCase: BaseUsernameUseCase.Save,
) : BaseValidationRegReducer.Abstract(uiStore, saveUsernameUseCase) {

    override suspend fun navigateNext() {
        uiStore.trySetEffect(RegistrationEffect.NavigateBirthday())
    }
}