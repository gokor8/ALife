package com.alife.anotherlife.ui.screen.login.state

import com.alife.core.mvi.MVI

sealed interface LoginEffect : MVI.Effect {

    class NavigateRegistration() : LoginEffect
}