package com.alife.domain.registration.usecase.email.send_reg_data

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.email.send_reg_data.mapper.BaseThrowToRegData
import javax.inject.Inject

class ThrowToRegData @Inject constructor() : BaseThrowToRegData {

    override fun map(inputModel: Throwable): UseCaseResult<Unit> {
        return UseCaseResult.Fail(inputModel)
    }
}