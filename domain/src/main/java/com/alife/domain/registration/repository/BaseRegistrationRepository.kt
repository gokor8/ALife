package com.alife.domain.registration.repository

import com.alife.domain.registration.core.entity.RegInputEntity

interface BaseRegistrationRepository {

    fun saveRegData(regEntity: RegInputEntity<*>)

    fun<M : Any> readRegData(regEntity: RegInputEntity<M>): M
}