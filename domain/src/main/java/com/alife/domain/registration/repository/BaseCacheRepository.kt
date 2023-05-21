package com.alife.domain.registration.repository

import com.alife.domain.registration.usecase.base.entity.ReadCacheInputEntity
import com.alife.domain.registration.usecase.base.entity.SaveCacheInputEntity

interface BaseCacheRepository<S : SaveCacheInputEntity<*>, R : ReadCacheInputEntity<*>> {

    fun saveData(saveEntity: S)

    fun<M : Any> readData(readEntity: R): M

    fun deleteData(readEntity: R)
}