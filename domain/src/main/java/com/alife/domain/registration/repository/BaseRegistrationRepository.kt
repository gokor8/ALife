package com.alife.domain.registration.repository

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.base.entity.ReadRegInputEntity
import com.alife.domain.registration.usecase.base.entity.SaveRegInputEntity
import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity

interface BaseRegistrationRepository {

    fun saveRegData(regEntity: SaveRegInputEntity<*>)

    fun<M : Any> readRegData(regEntity: ReadRegInputEntity<M>): M

    fun sendRegData(regDataEntity: RegDataEntity): UseCaseResult<Nothing>
}