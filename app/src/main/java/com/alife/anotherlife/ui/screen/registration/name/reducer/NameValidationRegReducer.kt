package com.alife.anotherlife.ui.screen.registration.name.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.name.NameAnnotation
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import javax.inject.Inject

class NameValidationRegReducer @Inject constructor(
    @NameAnnotation.NameUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>
) : BaseValidationRegReducer.Abstract(uiStore) {

    override fun navigateNext() {
        uiStore.trySetEffect(RegistrationEffect.NavigateUsername())
    }
}