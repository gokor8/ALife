package com.alife.domain.registration.usecase.email.send_reg_data

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity

interface BaseSendRegDataUseCase {

    suspend fun sendRegData()
}