package com.alife.data.repository.login.model

import com.alife.core.mapper.Mapper
import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.domain.registration.usecase.token.cache.TokenReadEntity
import com.alife.domain.registration.usecase.token.cache.TokenSaveEntity

interface BaseTokenSaveEntityToModel : Mapper<TokenSaveEntity, CacheModel.Write<*>>

interface BaseTokenReadEntityToModel : Mapper<TokenReadEntity, CacheModel.Read<*>>