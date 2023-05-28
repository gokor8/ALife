package com.alife.anotherlife.ui.screen.registration.base

import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.registration.base.reducer.RegistrationReducerBase
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationAction
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState

abstract class RegistrationViewModel(
    override val reducerVM: RegistrationReducerBase,
) : ViewModelLCE<RegistrationReducerBase, RegistrationAction, RegistrationState, RegistrationEffect>(
    reducerVM
) {

    override suspend fun onAction(action: RegistrationAction) = action.onAction(reducerVM)
}