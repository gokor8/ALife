package com.alife.domain.registration.repository

import com.alife.domain.registration.usecase.token.TokenReadEntity
import com.alife.domain.registration.usecase.token.TokenSaveEntity

interface BaseTokenCacheRepository : BaseCacheRepository<TokenSaveEntity, TokenReadEntity>
