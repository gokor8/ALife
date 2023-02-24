package com.alife.anotherlife.di.ui.login

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.login.state.LoginEffect
import com.alife.anotherlife.ui.screen.login.state.LoginState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
class LoginViewModelModuleP {

    @Provides
    fun loginUIStore(): UIStore<LoginState, LoginEffect> = DefaultUIStore(LoginState())
}