package com.alife.domain.registration.usecase.email

import com.alife.core.usecase.UseCaseEntity

interface RegDataState : UseCaseEntity {

    class Success : RegDataState

    class Fail : RegDataState
}