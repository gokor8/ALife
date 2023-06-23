package com.alife.data.repository.registration

import com.alife.core.mapper.Mapper
import com.alife.data.data_source.cache.shared.SharedCacheDataSource
import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.data.repository.CacheRepository
import com.alife.domain.registration.repository.BaseCacheRepository
import com.alife.domain.registration.repository.BaseRegCacheRepository
import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity
import javax.inject.Inject

class RegCacheRepository @Inject constructor(
    sharedCacheDataSource: SharedCacheDataSource,
    saveEntityToModel: Mapper<RegCacheInputEntity.Save<*>, CacheModel.Write<*>>,
    readEntityToModel: Mapper<RegCacheInputEntity.Read<*>, CacheModel.Read<*>>
) : BaseRegCacheRepository,
    CacheRepository<RegCacheInputEntity.Save<*>, RegCacheInputEntity.Read<*>>(
        sharedCacheDataSource,
        saveEntityToModel,
        readEntityToModel
    )