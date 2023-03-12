package com.alife.anotherlife.ui.screen.login.state

import com.alife.anotherlife.ui.screen.login.model.AuthType
import com.alife.anotherlife.ui.screen.login.reducer.LoginReducer
import com.alife.core.mvi.MVI

interface LoginAction : MVI.Action {

    suspend fun onAction(reducer: LoginReducer)

    class InitAction() : LoginAction {

        override suspend fun onAction(reducer: LoginReducer) {
            reducer.onInit()
        }
    }

    class AuthTypeAction(private val authType: AuthType): LoginAction {

        override suspend fun onAction(reducer: LoginReducer) {
            when(authType) {
                AuthType.LOGIN_IN -> reducer.onLoginIn()
                AuthType.REGISTRATION -> reducer.onRegistration()
                AuthType.AUTH_SERVICE -> reducer.onAuthService()
            }
        }
    }
}