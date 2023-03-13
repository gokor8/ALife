package com.alife.domain.registration.usecase.email.save_read.mapper

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.email.save_read.entity.EmailRegEntity
import javax.inject.Inject

class ThrowToEmailRegEntity  @Inject constructor() : ThrowableUCMapper<EmailRegEntity> {

    override fun map(inputModel: Throwable): UseCaseResult<EmailRegEntity> {
        return UseCaseResult.Fail(inputModel)
    }
}