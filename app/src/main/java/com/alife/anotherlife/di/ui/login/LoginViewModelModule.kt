package com.alife.anotherlife.di.ui.login

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.login.LoginReducerImplBase
import com.alife.anotherlife.ui.screen.login.reducer.BaseLoginReducerBase
import com.alife.anotherlife.ui.screen.login.state.LoginState

import dagger.Binds
import dagger.hilt.InstallIn
import dagger.Module
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface LoginViewModelModule {

    @Binds
    fun bindsReducer(reducer: LoginReducerImplBase): BaseLoginReducerBase

    @Binds
    fun bindUIStore(uiStore: DefaultUIStore<LoginState, Nothing>): UIStore<LoginState, Nothing>
}