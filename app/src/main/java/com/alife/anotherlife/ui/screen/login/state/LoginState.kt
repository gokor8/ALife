package com.alife.anotherlife.ui.screen.login.state

import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.core.mvi.MVI

data class LoginState(
    val supportedAuthService: List<UIAuthModel> = emptyList()
) : MVI.State