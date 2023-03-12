package com.alife.domain.registration.usecase.email_code

interface BaseEmailCodeUseCase {

    fun sendCode(code: String): EmailCodeState
}