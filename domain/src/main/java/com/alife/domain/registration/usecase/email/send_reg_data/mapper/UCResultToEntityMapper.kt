package com.alife.domain.registration.usecase.email.send_reg_data.mapper

import com.alife.core.usecase.UseCaseEntity
import com.alife.domain.core.usecase.UseCaseResult

interface UCResultToEntityMapper {

    fun <M : UseCaseEntity> map(inputModel: UseCaseResult<M>): M
}