package com.alife.domain.registration.repository

import com.alife.domain.registration.usecase.base.ReadRegInputEntity
import com.alife.domain.registration.usecase.base.SaveRegInputEntity
import com.alife.domain.registration.usecase.email.RegDataEntity
import com.alife.domain.registration.usecase.email.RegDataState

interface BaseRegistrationRepository {

    fun saveRegData(regEntity: SaveRegInputEntity<*>)

    fun<M : Any> readRegData(regEntity: ReadRegInputEntity<M>): M

    fun sendRegData(regDataEntity: RegDataEntity): RegDataState
}