package com.alife.domain.registration.usecase.reg_log.email.send_reg_data.mapper

import com.alife.core.usecase.UseCaseEntity
import com.alife.domain.core.usecase.UseCaseResult
import javax.inject.Inject

class UCResultToEntityToSuccess @Inject constructor() : UCResultToEntityMapper {

    override fun <M : UseCaseEntity> map(inputModel: UseCaseResult<M>): M {
        return when (inputModel) {
            is UseCaseResult.Success -> inputModel.model
            is UseCaseResult.Fail -> throw inputModel.exception
            else -> throw IllegalStateException()
        }
    }
}