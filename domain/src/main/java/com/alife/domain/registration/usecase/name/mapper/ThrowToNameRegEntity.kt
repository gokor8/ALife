package com.alife.domain.registration.usecase.name.mapper

import com.alife.core.mapper.Mapper
import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.core.entity.RegEntity
import com.alife.domain.registration.usecase.name.addons.NameRegEntity
import javax.inject.Inject

class ThrowToNameRegEntity @Inject constructor() : ThrowableMapper<NameRegEntity> {

    override fun map(inputModel: Throwable): NameRegEntity {
        return NameRegEntity(DefaultRegEntity.Fail(inputModel))
    }
}