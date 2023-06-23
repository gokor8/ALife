package com.alife.anotherlife.ui.screen.registration.email_code.reducer

import com.alife.anotherlife.core.composable.text.code.CodeReducer
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeEffect
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeState

abstract class AbstractEmailCodeRegReducerBase(
    val limit: Int = 6,
    val maskSymbol: Char = '•'
) : HandlerBaseVMReducer<EmailCodeState, EmailCodeEffect>(), CodeReducer