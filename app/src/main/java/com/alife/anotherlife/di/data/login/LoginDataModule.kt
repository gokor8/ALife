package com.alife.anotherlife.di.data.login

import com.alife.core.mapper.Mapper
import com.alife.data.interceptor.mapper.TokensModelToTokenStateEntity
import com.alife.data.interceptor.model.BaseTokenErrorChain
import com.alife.data.interceptor.model.RefreshTokenErrorChain
import com.alife.data.repository.login.TokenCacheRepository
import com.alife.data.repository.login.model.BaseTokenReadEntityToModel
import com.alife.data.repository.login.model.BaseTokenSaveEntityToModel
import com.alife.data.repository.login.model.TokenReadEntityToModel
import com.alife.data.repository.login.model.TokenSaveEntityToModel
import com.alife.domain.registration.repository.BaseTokenCacheRepository
import com.alife.domain.registration.usecase.token.BaseTokensModel
import com.alife.domain.registration.usecase.token.TokenStateEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
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
}