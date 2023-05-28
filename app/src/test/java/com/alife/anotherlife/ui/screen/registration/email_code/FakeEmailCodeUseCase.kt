package com.alife.anotherlife.ui.screen.registration.email_code

import com.alife.domain.registration.usecase.email_code.BaseEmailCodeUseCase
import java.lang.Exception

class FakeEmailCodeUseCase(
    private val exception: Exception? = null
) : BaseEmailCodeUseCase {

    override suspend fun sendCode(code: String) {
        exception?.let { throw it }
    }
}