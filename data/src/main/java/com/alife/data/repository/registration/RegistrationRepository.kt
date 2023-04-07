package com.alife.data.repository.registration

import com.alife.data.data_source.cache.shared.SharedCacheDataSource
import com.alife.data.repository.registration.mapper.BaseRegEntityToReadRegModel
import com.alife.data.repository.registration.mapper.BaseRegEntityToWriteRegModel
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.entity.ReadRegInputEntity
import com.alife.domain.registration.usecase.base.entity.SaveRegInputEntity
import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val sharedCacheDataSource: SharedCacheDataSource,
    private val baseRegEntityToWriteRegModel: BaseRegEntityToWriteRegModel,
    private val baseRegEntityToReadRegModel: BaseRegEntityToReadRegModel,
) : BaseRegistrationRepository {

    override fun saveRegData(regEntity: SaveRegInputEntity<*>) {
        sharedCacheDataSource.save(
            baseRegEntityToWriteRegModel.map(regEntity)
        )
    }

    override fun <M : Any> readRegData(regEntity: ReadRegInputEntity<M>): M {
        return sharedCacheDataSource.read(
            baseRegEntityToReadRegModel.map(regEntity)
        ) as M
    }

    override fun sendRegData(regDataEntity: RegDataEntity) {
        // throw Exception if was error in bek response
    }
}