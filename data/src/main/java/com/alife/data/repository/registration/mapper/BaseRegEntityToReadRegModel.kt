package com.alife.data.repository.registration.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.domain.registration.usecase.base.entity.ReadCacheInputEntity

interface BaseRegEntityToReadRegModel : Mapper<ReadCacheInputEntity<*>, CacheModel.Read<*>>