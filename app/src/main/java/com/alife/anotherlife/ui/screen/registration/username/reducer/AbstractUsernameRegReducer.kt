package com.alife.anotherlife.ui.screen.registration.username.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState

abstract class AbstractUsernameRegReducer(
    uiStore: UIStore<RegistrationState, RegistrationEffect>,
    nameChainValidator: BaseRegTextChain,
    validationNameRegReducer: BaseValidationRegReducer
) : BaseRegistrationReducer.Abstract(uiStore, nameChainValidator, validationNameRegReducer)