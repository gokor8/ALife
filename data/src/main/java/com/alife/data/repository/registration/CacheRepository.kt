package com.alife.data.repository.registration

import com.alife.data.data_source.cache.shared.SharedCacheDataSource
import com.alife.data.repository.registration.mapper.BaseRegEntityToReadRegModel
import com.alife.data.repository.registration.mapper.BaseRegEntityToWriteRegModel
import com.alife.domain.registration.repository.BaseCacheRegistrationRepository
import com.alife.domain.registration.usecase.base.entity.ReadCacheInputEntity
import com.alife.domain.registration.usecase.base.entity.SaveCacheInputEntity
import javax.inject.Inject

class CacheRepository @Inject constructor(
    private val sharedCacheDataSource: SharedCacheDataSource,
    private val baseRegEntityToWriteRegModel: BaseRegEntityToWriteRegModel,
    private val baseRegEntityToReadRegModel: BaseRegEntityToReadRegModel,
) : BaseCacheRegistrationRepository {

    override fun saveRegData(regEntity: SaveCacheInputEntity<*>) {
        sharedCacheDataSource.save(
            baseRegEntityToWriteRegModel.map(regEntity)
        )
    }

    override fun <M : Any> readRegData(regEntity: ReadCacheInputEntity<M>): M {
        return sharedCacheDataSource.read(
            baseRegEntityToReadRegModel.map(regEntity)
        ) as M
    }
}