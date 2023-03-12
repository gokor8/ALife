package com.alife.domain.login.registration_stage

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.core.entity.BoxRegEntity
import com.alife.domain.registration.core.entity.DefaultRegEntity
import javax.inject.Inject

class ThrowToRegStageEntity @Inject constructor(): ThrowableMapper<BoxRegEntity> {

    override fun map(inputModel: Throwable): BoxRegEntity {
        return RegStageEntity(DefaultRegEntity.Fail(inputModel))
    }
}