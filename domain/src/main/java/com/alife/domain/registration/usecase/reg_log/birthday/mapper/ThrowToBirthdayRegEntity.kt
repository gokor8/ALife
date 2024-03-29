package com.alife.domain.registration.usecase.reg_log.birthday.mapper

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.reg_log.birthday.entity.BirthdayRegEntity
import javax.inject.Inject

class ThrowToBirthdayRegEntity @Inject constructor() : ThrowableUCMapper<BirthdayRegEntity> {

    override fun map(inputModel: Throwable): UseCaseResult<BirthdayRegEntity> {
        return UseCaseResult.Fail(inputModel)
    }
}