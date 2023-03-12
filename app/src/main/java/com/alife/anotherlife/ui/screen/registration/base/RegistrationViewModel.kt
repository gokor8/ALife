package com.alife.anotherlife.ui.screen.registration.base

import com.alife.anotherlife.core.ui.view_model.BaseViewModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationAction
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState

abstract class RegistrationViewModel(
    override val reducerVM: RegistrationReducer,
) : BaseViewModel<RegistrationAction, RegistrationState, RegistrationEffect>() {

    override suspend fun onAction(action: RegistrationAction) = action.onAction(reducerVM)
}