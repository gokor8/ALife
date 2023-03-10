package com.alife.domain.registration.usecase.username.addons

import com.alife.domain.registration.usecase.entity.RegUseCaseEntity

interface UsernameRegEntity : RegUseCaseEntity {

    class Success(val username: String) : UsernameRegEntity, RegUseCaseEntity.Success

    class Fail : UsernameRegEntity, RegUseCaseEntity.Fail
}