package com.alife.domain.registration.usecase.birthday.mapper

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity
import javax.inject.Inject

class ThrowToBirthdayRegEntity @Inject constructor() : ThrowableMapper<BirthdayRegEntity> {

    override fun map(inputModel: Throwable): BirthdayRegEntity {
        return BirthdayRegEntity(DefaultRegEntity.Fail(inputModel))
    }
}