package com.alife.anotherlife.ui.screen.registration.username.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.RegAnnotations
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import javax.inject.Inject

class UsernameValidationRegReducer @Inject constructor(
    @RegAnnotations.RegUsernameUIStore
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
) : AbstractUsernameValidationRegReducer(uiStore) {

    override fun navigateNext() {
        uiStore.trySetEffect(RegistrationEffect.NavigateBirthday())
    }
}