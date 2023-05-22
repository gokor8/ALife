package com.alife.domain.registration.repository

import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity
import com.alife.domain.registration.usecase.email_code.EmailCodeState

interface BaseRegistrationRepository {

    suspend fun sendRegData(regDataEntity: RegDataEntity)

    suspend fun confirmCode(code: String)
}