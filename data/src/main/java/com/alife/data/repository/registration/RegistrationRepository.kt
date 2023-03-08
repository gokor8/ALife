package com.alife.data.repository.registration

import com.alife.data.data_source.SharedCacheDataSource
import com.alife.data.repository.registration.mapper.BaseRegEntityToReadRegModel
import com.alife.data.repository.registration.mapper.BaseRegEntityToWriteRegModel
import com.alife.domain.registration.entity.RegistrationEntity
import com.alife.domain.registration.repository.BaseRegistrationRepository
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val sharedCacheDataSource: SharedCacheDataSource,
    private val baseRegEntityToWriteRegModel: BaseRegEntityToWriteRegModel,
    private val baseRegEntityToReadRegModel: BaseRegEntityToReadRegModel,
) : BaseRegistrationRepository {

    override fun saveRegData(regEntity: RegistrationEntity<*>) {
        sharedCacheDataSource.save(
            baseRegEntityToWriteRegModel.map(regEntity)
        )
    }

    override fun <M : Any> readRegData(regEntity: RegistrationEntity<M>): M {
        return sharedCacheDataSource.read(
            baseRegEntityToReadRegModel.map(regEntity)
        ) as M
    }
}