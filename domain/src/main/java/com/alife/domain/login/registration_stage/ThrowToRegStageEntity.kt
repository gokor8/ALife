package com.alife.domain.login.registration_stage

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.core.entity.BoxRegEntity
import javax.inject.Inject

class ThrowToRegStageEntity @Inject constructor(): ThrowableUCMapper<BoxRegEntity> {

    override fun map(inputModel: Throwable): UseCaseResult<BoxRegEntity> {
        return UseCaseResult.Fail(inputModel)
    }
}