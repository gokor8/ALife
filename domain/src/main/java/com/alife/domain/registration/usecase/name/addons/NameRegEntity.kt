package com.alife.domain.registration.usecase.name.addons

import com.alife.core.usecase.UseCaseEntity
import com.alife.domain.registration.usecase.entity.RegUseCaseEntity
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity

interface NameRegEntity : RegUseCaseEntity {

    class Success(val username: String) : UsernameRegEntity, RegUseCaseEntity.Success

    class Fail : UsernameRegEntity, RegUseCaseEntity.Fail
}