package com.alife.anotherlife.di.ui.login

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.login.LoginReducerImpl
import com.alife.anotherlife.ui.screen.login.reducer.AbstractLoginReducer
import com.alife.anotherlife.ui.screen.login.state.LoginState
import dagger.Binds
import dagger.hilt.InstallIn
import dagger.Module
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LoginViewModelModule {

    @Binds
    fun bindsReducer(reducer: LoginReducerImpl): AbstractLoginReducer

    @Binds
    fun bindUIStore(uiStore: DefaultUIStore<LoginState, Nothing>): UIStore<LoginState, Nothing>
}