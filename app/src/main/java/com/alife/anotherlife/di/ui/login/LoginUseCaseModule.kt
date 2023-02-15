package com.alife.anotherlife.di.ui.login

import com.alife.domain.login.base.LoginAuthType
import com.alife.domain.login.LoginAuthTypeUseCase
import com.alife.domain.login.MockAuthTypeUseCase
import com.alife.domain.login.base.ListAuthType
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface LoginUseCaseModule {

    @LoginUseCaseAnnotations.LoginATUseCase
    @Binds
    fun loginAuthTypeUseCase(useCase: LoginAuthTypeUseCase): LoginAuthType

    @LoginUseCaseAnnotations.MockATUseCase
    @Binds
    fun mockAuthTypeUseCase(useCase: MockAuthTypeUseCase): ListAuthType
}