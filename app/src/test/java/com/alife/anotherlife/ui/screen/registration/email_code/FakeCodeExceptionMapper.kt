package com.alife.anotherlife.ui.screen.registration.email_code

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.registration.email_code.mapper.BaseCodeExceptionMapper
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeEffect
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeState
import com.alife.core.mvi.addons.BaseMVIHandlers
import java.lang.Exception

class FakeCodeExceptionMapper(
    private val fakeUIStore: FakeUIStore<EmailCodeState, EmailCodeEffect>
) : BaseCodeExceptionMapper {

    override fun map(
        exception: Exception,
        handler: BaseMVIHandlers<EmailCodeState, EmailCodeEffect>
    ): EmailCodeState {
        fakeUIStore.trySetEffect(TestEmailCodeRegReducer_Filled.ExceptionHandledEffect())
        return handler.getState()
    }
}