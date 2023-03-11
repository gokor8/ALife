package com.alife.domain.registration.usecase.email.mapper

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.usecase.email.entity.EmailRegEntity
import javax.inject.Inject

class ThrowToEmailRegEntity  @Inject constructor() : ThrowableMapper<EmailRegEntity> {

    override fun map(inputModel: Throwable): EmailRegEntity {
        return EmailRegEntity(DefaultRegEntity.Fail(inputModel))
    }
}