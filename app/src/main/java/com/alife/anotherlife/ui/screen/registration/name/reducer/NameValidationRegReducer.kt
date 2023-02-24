package com.alife.anotherlife.ui.screen.registration.name.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.RegAnnotations
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import javax.inject.Inject

class NameValidationRegReducer @Inject constructor(
    @RegAnnotations.RegNameUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>
) : AbstractNameValidationRegReducer(uiStore) {

    override fun navigateNext() {
        uiStore.trySetEffect(RegistrationEffect.NavigateUsername())
    }
}