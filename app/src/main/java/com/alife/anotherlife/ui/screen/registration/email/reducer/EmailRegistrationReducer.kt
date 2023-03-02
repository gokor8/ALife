package com.alife.anotherlife.ui.screen.registration.email.reducer

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.registration.email.EmailAnnotation
import com.alife.anotherlife.di.ui.registration.name.NameAnnotation
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import javax.inject.Inject

class EmailRegistrationReducer @Inject constructor(
    @EmailAnnotation.EmailUIStore
    reducer: UIStore<RegistrationState, RegistrationEffect>,
    @EmailAnnotation.EmailChain
    chain: BaseRegTextChain,
    @EmailAnnotation.EmailValidation
    validationNameRegReducer: BaseValidationRegReducer,
) : BaseRegistrationReducer.Abstract(reducer, chain, validationNameRegReducer)