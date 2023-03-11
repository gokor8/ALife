package com.alife.domain.registration.repository

import com.alife.domain.registration.core.entity.RegInputEntity
import com.alife.domain.registration.usecase.base.ReadRegInputEntity
import com.alife.domain.registration.usecase.base.SaveRegInputEntity

interface BaseRegistrationRepository {

    fun saveRegData(regEntity: SaveRegInputEntity<*>)

    fun<M : Any> readRegData(regEntity: ReadRegInputEntity<M>): M
}