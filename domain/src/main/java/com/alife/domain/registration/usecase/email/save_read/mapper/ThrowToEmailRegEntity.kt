package com.alife.domain.registration.usecase.email.save_read.mapper

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.usecase.email.save_read.entity.BoxEmailRegEntity
import javax.inject.Inject

class ThrowToEmailRegEntity  @Inject constructor() : ThrowableMapper<BoxEmailRegEntity> {

    override fun map(inputModel: Throwable): BoxEmailRegEntity {
        return BoxEmailRegEntity(DefaultRegEntity.Fail(inputModel))
    }
}