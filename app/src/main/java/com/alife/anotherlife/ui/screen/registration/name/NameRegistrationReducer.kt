package com.alife.anotherlife.ui.screen.registration.name

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.RegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState

class NameRegistrationReducer(
    uiStore: UIStore<RegistrationState, RegistrationEffect>
) : RegistrationReducer(uiStore) {

    override fun onTextInput(text: String) {
        
    }

    override fun onNextClick() {

    }
}