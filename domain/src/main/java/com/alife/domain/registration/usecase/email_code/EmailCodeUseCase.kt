package com.alife.domain.registration.usecase.email_code

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.core.usecase.AbstractSafeUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class EmailCodeUseCase @Inject constructor(
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<EmailCodeState>
) : AbstractSafeUseCase<EmailCodeState>(dispatcher, exceptionMapper), BaseEmailCodeUseCase {

    override fun sendCode(code: String): EmailCodeState {
        return EmailCodeState.Success()
    }
}