package com.alife.anotherlife.ui.screen.registration.username.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.username.UsernameAnnotation
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.domain.registration.usecase.name.BaseNameUseCase
import com.alife.domain.registration.usecase.username.BaseUsernameUseCase
import javax.inject.Inject

class UsernameValidationRegReducer @Inject constructor(
    @UsernameAnnotation.UsernameUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    private val saveUsernameUseCase: BaseUsernameUseCase.Save,
) : BaseValidationRegReducer.Abstract(uiStore) {

    override suspend fun navigateNext() {
        saveUsernameUseCase.saveData(getState().textWithErrorModel.getCurrentText())
        uiStore.trySetEffect(RegistrationEffect.NavigateBirthday())
    }
}