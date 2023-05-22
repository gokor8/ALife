package com.alife.domain.registration.usecase.email_code

interface BaseEmailCodeUseCase {

    suspend fun sendCode(code: String)
}