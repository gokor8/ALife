package com.alife.anotherlife.ui.screen.login.reducer

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.login.state.LoginEffect
import com.alife.anotherlife.ui.screen.login.state.LoginState

interface BaseLoginReducerBase : BaseVMReducer<LoginState, LoginEffect>, LoginReducer