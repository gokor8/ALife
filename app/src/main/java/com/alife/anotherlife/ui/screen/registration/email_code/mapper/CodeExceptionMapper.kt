package com.alife.anotherlife.ui.screen.registration.email_code.mapper

import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.state.lce.LCEError
import com.alife.anotherlife.core.ui.text.TextWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeState
import com.alife.data.repository.registration.model.CodeException
import java.lang.Exception

interface BaseCodeExceptionMapper {

    fun map(exception: java.lang.Exception, state: EmailCodeState): CreateAlifeState
}

class CodeExceptionMapper : BaseCodeExceptionMapper {
    override fun map(exception: Exception, state: EmailCodeState): CreateAlifeState {
        if (exception is CodeException) {
            state.copy(error = TextWrapper.ResWrapper(R.string.email_code_error))
        } else {
            state.copy(
                lceModel = LCEError(
                    TextWrapper.ResWrapper(R.string.exception),
                    TextWrapper.ResWrapper(R.string.email_code_critical_error),
                    TextWrapper.ResWrapper(R.string.back)
                ) { state }
            )
        }
    }
}