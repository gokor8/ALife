package com.alife.anotherlife.ui.screen.registration.base

import com.alife.anotherlife.core.ui.view_model.AbstractViewModel
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducer
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationAction
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState

abstract class RegistrationViewModel(
    override val reducerVM: RegistrationReducer,
) : AbstractViewModel<RegistrationAction, RegistrationState, RegistrationEffect>() {

    override suspend fun onAction(action: RegistrationAction) = action.onAction(reducerVM)
}