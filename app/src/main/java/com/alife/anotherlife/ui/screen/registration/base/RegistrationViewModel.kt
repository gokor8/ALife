package com.alife.anotherlife.ui.screen.registration.base

import com.alife.anotherlife.core.ui.view_model.BaseViewModel
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationAction
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import dagger.hilt.android.lifecycle.HiltViewModel

abstract class RegistrationViewModel(
    override val reducerVM: RegistrationReducer,
) : BaseViewModel<RegistrationAction, RegistrationState, RegistrationEffect>() {

    override suspend fun onAction(action: RegistrationAction) = action.onAction(reducerVM)
}