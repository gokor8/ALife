package com.alife.data.repository.registration.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.domain.registration.usecase.base.entity.ReadCacheInputEntity
import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity

interface BaseReadCacheInputEntityToReadRegModel : Mapper<RegCacheInputEntity.Read<*>, CacheModel.Read<*>>