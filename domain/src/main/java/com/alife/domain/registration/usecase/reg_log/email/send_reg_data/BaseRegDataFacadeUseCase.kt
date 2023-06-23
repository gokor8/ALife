package com.alife.domain.registration.usecase.reg_log.email.send_reg_data

import com.alife.domain.registration.usecase.reg_log.email.send_reg_data.entity.RegDataEntity

interface BaseRegDataFacadeUseCase {

    suspend fun fillRegData(): RegDataEntity
}