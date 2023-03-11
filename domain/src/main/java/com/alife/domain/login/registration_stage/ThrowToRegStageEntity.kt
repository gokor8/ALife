package com.alife.domain.login.registration_stage

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.core.entity.DefaultRegEntity
import javax.inject.Inject

class ThrowToRegStageEntity @Inject constructor(): ThrowableMapper<RegStageEntity> {

    override fun map(inputModel: Throwable): RegStageEntity {
        return RegStageEntity(DefaultRegEntity.Fail(inputModel))
    }
}