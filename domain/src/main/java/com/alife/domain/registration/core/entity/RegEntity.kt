package com.alife.domain.registration.core.entity

import com.alife.core.usecase.UseCaseEntity

interface RegEntity : UseCaseEntity {

    interface Success : RegEntity

    interface Fail : RegEntity
}