package com.alife.domain.registration.repository

import com.alife.domain.registration.usecase.base.entity.ReadCacheInputEntity
import com.alife.domain.registration.usecase.base.entity.SaveCacheInputEntity

interface BaseCacheRegistrationRepository {

    fun saveRegData(regEntity: SaveCacheInputEntity<*>)

    fun<M : Any> readRegData(regEntity: ReadCacheInputEntity<M>): M
}