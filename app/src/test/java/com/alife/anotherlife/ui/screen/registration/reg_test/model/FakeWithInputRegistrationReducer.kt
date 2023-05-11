package com.alife.anotherlife.ui.screen.registration.reg_test.model

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseRegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.name.FakeInputRegTextChain

// TODO fix it
//class FakeWithInputRegistrationReducer(
//    uiStore: UIStore<RegistrationState, RegistrationEffect>,
//    chainValidator: BaseRegTextChain,
//    validationRegReducer: BaseValidationRegReducer,
//    inputRegTextChain: FakeInputRegTextChain
//) : BaseRegistrationReducer.WithInputChain(
//    uiStore, chainValidator, validationRegReducer, inputRegTextChain
//) {
//
//    override suspend fun onBackPress() {
//        TODO("Not yet implemented")
//    }
//}