package com.alife.domain.registration.usecase.email_code

import com.alife.domain.core.mapper.ThrowableMapper
import javax.inject.Inject

class ThrowableToEmailCodeState @Inject constructor() : ThrowableMapper<EmailCodeState> {

    override fun map(inputModel: Throwable): EmailCodeState {
        return EmailCodeState.Fail()
    }
}