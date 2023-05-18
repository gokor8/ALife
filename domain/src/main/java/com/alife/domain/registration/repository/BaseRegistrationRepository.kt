package com.alife.domain.registration.repository

import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity

interface BaseRegistrationRepository {

    suspend fun sendRegData(regDataEntity: RegDataEntity)

    suspend fun confirmCode(code: String)
}