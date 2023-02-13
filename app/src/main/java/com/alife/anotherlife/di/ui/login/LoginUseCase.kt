package com.alife.anotherlife.di.ui.login

import com.alife.domain.login.LoginAuthTypeUseCase
import com.alife.domain.login.MockAuthTypeUseCase
import com.alife.domain.login.base.BaseLoginAuthTypeUseCase
import com.alife.domain.login.base.BaseMockAuthTypeUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
interface LoginUseCase {

    @Binds
    fun loginAuthTypeUseCase(useCase: LoginAuthTypeUseCase): BaseLoginAuthTypeUseCase

    @Binds
    fun mockAuthTypeUseCase(useCase: MockAuthTypeUseCase): BaseMockAuthTypeUseCase
}