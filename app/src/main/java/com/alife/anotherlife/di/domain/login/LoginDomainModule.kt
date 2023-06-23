package com.alife.anotherlife.di.domain.login

import com.alife.domain.registration.usecase.token.cache.BaseTokensUseCase
import com.alife.domain.registration.usecase.token.cache.TokensUseCase
import com.alife.domain.registration.usecase.token.cloud.BaseTokenCheckUseCase
import com.alife.domain.registration.usecase.token.cloud.TokenCheckUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LoginDomainModule {

    @Binds
    fun bindTokensUseCase(useCase: TokensUseCase): BaseTokensUseCase

    @Binds
    fun bindTokenCheckUseCase(useCase: TokenCheckUseCase): BaseTokenCheckUseCase
}