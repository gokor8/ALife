package com.alife.anotherlife.ui.screen.login

import com.alife.anotherlife.core.ui.view_model.AbstractViewModel
import com.alife.anotherlife.ui.screen.login.model.AuthType
import com.alife.anotherlife.ui.screen.login.reducer.BaseLoginReducerBase
import com.alife.anotherlife.ui.screen.login.state.LoginAction
import com.alife.anotherlife.ui.screen.login.state.LoginEffect
import com.alife.anotherlife.ui.screen.login.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    override val reducerVM: BaseLoginReducerBase,
) : AbstractViewModel<LoginAction, LoginState, LoginEffect>() {

    override suspend fun onAction(action: LoginAction) = action.onAction(reducerVM)

    fun onAuthTypeAction(authType: AuthType) = reduce(LoginAction.AuthTypeAction(authType))
}