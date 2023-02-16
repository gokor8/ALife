package com.alife.anotherlife.di.ui.login

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.login.LoginReducerImpl
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseDefaultAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseListAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseMockAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.DefaultAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.ListAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.container.LoginAuthTypeToContainerUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.MockAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.container.UIAuthToColumnContainerUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseLoginAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseUIAuthToColumnUIAuth
import com.alife.anotherlife.ui.screen.login.reducer.AbstractLoginReducer
import com.alife.anotherlife.ui.screen.login.state.LoginState
import dagger.Binds
import dagger.hilt.InstallIn
import dagger.Module
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface LoginViewModelModule {

    @Binds
    fun bindsReducer(reducer: LoginReducerImpl): AbstractLoginReducer

    @Binds
    fun bindUIStore(uiStore: DefaultUIStore<LoginState, Nothing>): UIStore<LoginState, Nothing>

    @Binds
    fun uiAuthToColumnUIAuth(mapper: UIAuthToColumnContainerUIAuth): BaseUIAuthToColumnUIAuth
    @Binds
    fun loginAuthTypeToUIAuth(mapper: LoginAuthTypeToContainerUIAuth): BaseLoginAuthTypeToUIAuth

    @Binds
    fun listAuthTypeToUIAuth(mapper: ListAuthTypeToUIAuth): BaseListAuthTypeToUIAuth

    @Binds
    fun defaultAuthTypeToUIAuth(mapper: DefaultAuthTypeToUIAuth): BaseDefaultAuthTypeToUIAuth

    @Binds
    fun mockAuthTypeToUIAuth(mapper: MockAuthTypeToUIAuth): BaseMockAuthTypeToUIAuth
}