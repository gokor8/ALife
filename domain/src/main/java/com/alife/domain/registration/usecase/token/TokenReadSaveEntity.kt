package com.alife.domain.registration.usecase.token

import com.alife.domain.registration.usecase.base.entity.ReadCacheInputEntity
import com.alife.domain.registration.usecase.base.entity.SaveCacheInputEntity

class TokenSaveEntity(
    val authorizationToken: String,
    val refreshToken: String
) : SaveCacheInputEntity<BaseTokensModel>

class TokenReadEntity : ReadCacheInputEntity<BaseTokensModel>