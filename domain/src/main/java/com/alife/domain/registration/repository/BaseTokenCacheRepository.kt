package com.alife.domain.registration.repository

import com.alife.domain.registration.usecase.token.cache.TokenReadEntity
import com.alife.domain.registration.usecase.token.cache.TokenSaveEntity

interface BaseTokenCacheRepository : BaseCacheRepository<TokenSaveEntity, TokenReadEntity>
