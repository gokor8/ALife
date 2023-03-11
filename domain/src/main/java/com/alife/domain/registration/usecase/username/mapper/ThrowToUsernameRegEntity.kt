package com.alife.domain.registration.usecase.username.mapper

import com.alife.core.mapper.Mapper
import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.core.entity.RegEntity
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity
import javax.inject.Inject

class ThrowToUsernameRegEntity @Inject constructor() : ThrowableMapper<UsernameRegEntity> {

    override fun map(inputModel: Throwable): UsernameRegEntity {
        return UsernameRegEntity(DefaultRegEntity.Fail(inputModel))
    }
}