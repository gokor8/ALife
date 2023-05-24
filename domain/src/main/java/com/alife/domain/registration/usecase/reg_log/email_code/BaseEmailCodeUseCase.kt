package com.alife.domain.registration.usecase.reg_log.email_code

interface BaseEmailCodeUseCase {

    suspend fun sendCode(code: String)
}