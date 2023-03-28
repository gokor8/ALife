package com.alife.domain.registration.usecase.username.mapper

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity
import javax.inject.Inject

class ThrowToUsernameRegEntity @Inject constructor() : ThrowableUCMapper<UsernameRegEntity> {

    override fun map(inputModel: Throwable): UseCaseResult<UsernameRegEntity> {
        return UseCaseResult.Fail(inputModel)
    }
}