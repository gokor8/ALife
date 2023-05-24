package com.alife.domain.registration.usecase.reg_log.email_code

import com.alife.domain.core.mapper.ThrowableMapper
import javax.inject.Inject

class ThrowableToEmailCodeState @Inject constructor() : ThrowableMapper<EmailCodeState> {

    override fun map(inputModel: Throwable): EmailCodeState {
        return EmailCodeState.Fail()
    }
}