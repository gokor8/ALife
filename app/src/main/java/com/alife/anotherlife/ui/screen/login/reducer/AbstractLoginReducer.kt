package com.alife.anotherlife.ui.screen.login.reducer

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.login.state.LoginState

abstract class AbstractLoginReducer : BaseVMReducer<LoginState, Nothing>(), LoginReducer