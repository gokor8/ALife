package com.alife.anotherlife.ui.screen.registration.name.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.name.NameAnnotation
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.domain.registration.usecase.name.BaseNameUseCase
import javax.inject.Inject

class NameValidationRegReducer @Inject constructor(
    @NameAnnotation.NameUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    private val saveNameUseCase: BaseNameUseCase.Save,
) : BaseValidationRegReducer.Abstract(uiStore) {

    override suspend fun navigateNext() {
        saveNameUseCase.saveData(getState().textWithErrorModel.getCurrentText())
        uiStore.trySetEffect(RegistrationEffect.NavigateUsername())
    }
}