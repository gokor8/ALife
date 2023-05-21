package com.alife.anotherlife.di.domain.login

import com.alife.domain.registration.usecase.token.BaseTokensUseCase
import com.alife.domain.registration.usecase.token.TokensUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface LoginDomainModule {

    @Binds
    fun bindTokensUseCase(useCase: TokensUseCase): BaseTokensUseCase
}