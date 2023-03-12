package com.alife.domain.registration.usecase.email_code

import com.alife.core.usecase.UseCaseEntity

interface EmailCodeState : UseCaseEntity {

    class Success : EmailCodeState

    class Fail : EmailCodeState
}