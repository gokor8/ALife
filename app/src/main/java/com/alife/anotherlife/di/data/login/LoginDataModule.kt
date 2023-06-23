package com.alife.anotherlife.di.data.login

import com.alife.core.mapper.Mapper
import com.alife.data.core.BaseTokenRequestFactory
import com.alife.data.core.TokenRequestFactory
import com.alife.data.interceptor.mapper.TokensModelToTokenStateEntity
import com.alife.data.interceptor.mapper.TokensModelToTokensEntity
import com.alife.data.interceptor.model.TokensModel
import com.alife.data.repository.login.TokenCacheRepository
import com.alife.data.repository.login.model.BaseTokenReadEntityToModel
import com.alife.data.repository.login.model.BaseTokenSaveEntityToModel
import com.alife.data.repository.login.model.TokenReadEntityToModel
import com.alife.data.repository.login.model.TokenSaveEntityToModel
import com.alife.data.repository.registration.RegistrationRepository
import com.alife.data.repository.registration.mapper.BaseRegDataEntityToRequest
import com.alife.data.repository.registration.mapper.RegDataEntityToRequest
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.repository.BaseTokenCacheRepository
import com.alife.domain.registration.usecase.token.cache.BaseTokensModel
import com.alife.domain.registration.usecase.token.cache.TokenStateEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LoginDataModule {

    @Binds
    fun bindTokenCacheRepository(repository: TokenCacheRepository): BaseTokenCacheRepository

    @Binds
    fun bindRegEntityToWriteRegModel(mapper: TokenSaveEntityToModel): BaseTokenSaveEntityToModel

    @Binds
    fun bindRegEntityToReadRegModel(mapper: TokenReadEntityToModel): BaseTokenReadEntityToModel

    @Binds
    fun bindTokensModelToTokenStateEntity(mapper: TokensModelToTokenStateEntity)
            : Mapper<BaseTokensModel, TokenStateEntity>

    @Binds
    fun bindTokensModelToTokensEntity(mapper: TokensModelToTokensEntity): Mapper<TokensModel, TokenStateEntity.Fill>

    @Binds
    fun bindTokenRequestFactory(factory: TokenRequestFactory): BaseTokenRequestFactory

    @Binds
    fun bindRegistrationRepository(repository: RegistrationRepository): BaseRegistrationRepository

    @Binds
    fun bindRegDataEntityToRequest(mapper: RegDataEntityToRequest): BaseRegDataEntityToRequest
}