package com.alife.anotherlife.ui.screen.registration.email_code.mapper

import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.state.lce.GenericLCEError
import com.alife.anotherlife.core.ui.state.lce.LCEError
import com.alife.anotherlife.core.ui.text.TextWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeEffect
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeState
import com.alife.core.mvi.addons.BaseMVIHandlers
import com.alife.data.core.GenericException
import com.alife.data.repository.registration.model.CodeException
import java.lang.Exception
import javax.inject.Inject

interface BaseCodeExceptionMapper {

    fun map(
        exception: Exception,
        handler: BaseMVIHandlers<EmailCodeState, EmailCodeEffect>
    ): EmailCodeState
}

class CodeExceptionMapper @Inject constructor() : BaseCodeExceptionMapper {

    override fun map(
        exception: Exception,
        handler: BaseMVIHandlers<EmailCodeState, EmailCodeEffect>
    ): EmailCodeState {
        val state = handler.getState()

        val onExc = { handler.trySetEffect(EmailCodeEffect.GoBack()) }

        return when (exception) {
            is CodeException -> state.copy(
                error = TextWrapper.ResWrapper(R.string.email_code_error)
            )
            is GenericException -> state.copy(lceModel = GenericLCEError(onExc))
            else -> state.copy(
                lceModel = LCEError(
                    TextWrapper.ResWrapper(R.string.exception),
                    TextWrapper.ResWrapper(R.string.email_code_critical_error),
                    TextWrapper.ResWrapper(R.string.back),
                    onExc
                )
            )
        }
    }
}