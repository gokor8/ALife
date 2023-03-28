package com.alife.domain.registration.usecase.email_code

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.AbstractSafeUseCaseResult
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class EmailCodeUseCaseResult @Inject constructor(
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableUCMapper<EmailCodeState>
) : AbstractSafeUseCaseResult<EmailCodeState>(dispatcher, exceptionMapper), BaseEmailCodeUseCase {

    override fun sendCode(code: String): EmailCodeState {
        return EmailCodeState.Success()
    }
}