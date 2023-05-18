package com.alife.domain.registration.repository

import com.alife.domain.registration.usecase.base.entity.ReadRegInputEntity
import com.alife.domain.registration.usecase.base.entity.SaveRegInputEntity

interface BaseCacheRegistrationRepository {

    fun saveRegData(regEntity: SaveRegInputEntity<*>)

    fun<M : Any> readRegData(regEntity: ReadRegInputEntity<M>): M
}