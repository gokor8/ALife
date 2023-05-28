package com.alife.domain.registration.repository

import com.alife.domain.registration.usecase.reg_log.email.send_reg_data.entity.RegDataEntity
import com.alife.domain.registration.usecase.token.cache.TokenStateEntity

interface BaseRegistrationRepository {

    suspend fun checkToken()

    suspend fun sendRegData(regDataEntity: RegDataEntity)

    suspend fun confirmCode(email: String, code: String): TokenStateEntity.Fill
}