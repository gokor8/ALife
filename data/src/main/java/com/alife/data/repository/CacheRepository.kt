package com.alife.data.repository

import com.alife.core.mapper.Mapper
import com.alife.data.data_source.cache.shared.SharedCacheDataSource
import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.domain.registration.repository.BaseCacheRepository
import com.alife.domain.registration.usecase.base.entity.ReadCacheInputEntity
import com.alife.domain.registration.usecase.base.entity.SaveCacheInputEntity

abstract class CacheRepository<S : SaveCacheInputEntity<*>, R : ReadCacheInputEntity<*>> (
    private val sharedCacheDataSource: SharedCacheDataSource,
    private val saveEntityToModel: Mapper<S, CacheModel.Write<*>>,
    private val readEntityToModel: Mapper<R, CacheModel.Read<*>>,
) : BaseCacheRepository<S, R> {

    override fun saveData(saveEntity: S) {
        sharedCacheDataSource.save(saveEntityToModel.map(saveEntity))
    }

    override fun <M : Any> readData(readEntity: R): M {
        return sharedCacheDataSource.read(readEntityToModel.map(readEntity)) as M
    }

    override fun deleteData(readEntity: R) {
        sharedCacheDataSource.delete(readEntityToModel.map(readEntity))
    }
}