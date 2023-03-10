package com.alife.domain.registration.usecase.entity

import com.alife.core.usecase.UseCaseEntity

interface RegUseCaseEntity : UseCaseEntity {

    interface Success : RegUseCaseEntity

    interface Fail : RegUseCaseEntity
}