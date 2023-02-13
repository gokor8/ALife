package com.alife.anotherlife.di.ui.login

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.ui.screen.login.state.LoginState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LoginViewModelModuleP {

    @Provides
    fun loginViewModel() = DefaultUIStore<LoginState, Nothing>(LoginState())
}