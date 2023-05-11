package com.alife.anotherlife.ui.screen.registration.reg_test.model

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState

// TODO Fix it
//class FakeAbstractRegistrationReducer(
//    uiStore: UIStore<RegistrationState, RegistrationEffect>,
//    chainValidator: BaseRegTextChain,
//    validationRegReducer: BaseValidationRegReducer
//) : BaseRegistrationReducer.Abstract(uiStore, chainValidator, validationRegReducer) {
//
//    override suspend fun onBackPress() {
//        // TODO would watch is need fill it
//    }
//}