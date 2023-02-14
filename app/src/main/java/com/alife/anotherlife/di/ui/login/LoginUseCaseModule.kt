package com.alife.anotherlife.di.ui.login

import com.alife.domain.login.LoginAuthType
import com.alife.domain.login.LoginAuthTypeUseCase
import com.alife.domain.login.MockAuthTypeUseCase
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
    fun mockAuthTypeUseCase(useCase: MockAuthTypeUseCase): LoginAuthType
}