package com.alife.data.repository.registration

import com.alife.data.data_source.SharedCacheDataSource
import com.alife.data.repository.registration.mapper.BaseRegEntityToReadRegModel
import com.alife.data.repository.registration.mapper.BaseRegEntityToWriteRegModel
import com.alife.domain.registration.core.entity.RegEntity
import com.alife.domain.registration.core.entity.RegInputEntity
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.ReadRegInputEntity
import com.alife.domain.registration.usecase.base.SaveRegInputEntity
import com.alife.domain.registration.usecase.email.RegDataEntity
import com.alife.domain.registration.usecase.email.RegDataState
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

    override fun sendRegData(regDataEntity: RegDataEntity): RegDataState {
        return RegDataState.Success()
    }
}