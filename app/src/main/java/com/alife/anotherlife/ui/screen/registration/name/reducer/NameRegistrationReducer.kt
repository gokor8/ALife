package com.alife.anotherlife.ui.screen.registration.name.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.RegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.state.BaseRegistrationState
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.name.chain.BaseNameChainValidator

class NameRegistrationReducer(
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    private val nameChainValidator: BaseNameChainValidator,
    private val validationNameRegReducer: BaseValidationNameRegReducer
) : RegistrationReducer(uiStore) {

    override fun onNextClick() {
        nameChainValidator.handle(
            uiStore.getState().textWithErrorModel.text
        ).onChainResult(validationNameRegReducer)
    }
}