package com.alife.data.repository.login

import com.alife.data.data_source.cache.shared.SharedCacheDataSource
import com.alife.data.repository.CacheRepository
import com.alife.data.repository.login.model.BaseTokenReadEntityToModel
import com.alife.data.repository.login.model.BaseTokenSaveEntityToModel
import com.alife.domain.registration.repository.BaseTokenCacheRepository
import com.alife.domain.registration.usecase.token.cache.TokenReadEntity
import com.alife.domain.registration.usecase.token.cache.TokenSaveEntity
import javax.inject.Inject

class TokenCacheRepository @Inject constructor(
    sharedCacheDataSource: SharedCacheDataSource,
    saveEntityToModel: BaseTokenSaveEntityToModel,
    readEntityToModel: BaseTokenReadEntityToModel
) : BaseTokenCacheRepository, CacheRepository<TokenSaveEntity, TokenReadEntity>(
    sharedCacheDataSource,
    saveEntityToModel,
    readEntityToModel
)