package com.alife.domain.registration.core.entity

import com.alife.core.usecase.UseCaseEntity

// TODO Need full remove

interface RegEntity : UseCaseEntity {

    interface Success : RegEntity

    interface Fail : RegEntity
}