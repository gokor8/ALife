package com.alife.domain.registration.usecase.email.send_reg_data

import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity

interface BaseRegDataFacadeUseCase {

    suspend fun fillRegData(): RegDataEntity
}