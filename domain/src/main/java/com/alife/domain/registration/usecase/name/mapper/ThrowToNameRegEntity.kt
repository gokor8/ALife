package com.alife.domain.registration.usecase.name.mapper

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.name.addons.NameRegEntity
import javax.inject.Inject

class ThrowToNameRegEntity @Inject constructor() : ThrowableUCMapper<NameRegEntity> {

    override fun map(inputModel: Throwable): UseCaseResult<NameRegEntity> {
        return UseCaseResult.Fail(inputModel)
    }
}