package com.alife.domain.registration.repository

import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity

interface BaseRegCacheRepository :
    BaseCacheRepository<RegCacheInputEntity.Save<*>, RegCacheInputEntity.Read<*>>