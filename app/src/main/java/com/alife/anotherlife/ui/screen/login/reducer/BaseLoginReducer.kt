package com.alife.anotherlife.ui.screen.login.reducer

import com.alife.anotherlife.core.ui.reducer.VMReducer
import com.alife.anotherlife.ui.screen.login.state.LoginEffect
import com.alife.anotherlife.ui.screen.login.state.LoginState

interface BaseLoginReducer : VMReducer<LoginState, LoginEffect>, LoginReducer