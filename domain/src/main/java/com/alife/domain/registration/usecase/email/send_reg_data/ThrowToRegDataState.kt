package com.alife.domain.registration.usecase.email.send_reg_data

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity
import javax.inject.Inject

class ThrowToRegDataState @Inject constructor() : ThrowableUCMapper<RegDataEntity> {

    override fun map(inputModel: Throwable): UseCaseResult<RegDataEntity> {
        return UseCaseResult.Fail(inputModel)
    }
}