package com.alife.anotherlife.ui.screen.registration.email_code.reducer

import com.alife.anotherlife.core.composable.text.code.CodeReducer
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeEffect
import com.alife.anotherlife.ui.screen.registration.email_code.state.EmailCodeState

abstract class BaseEmailCodeRegReducer(
    val limit: Int = 6,
    val maskSymbol: Char = '•'
) : BaseVMReducer<EmailCodeState, EmailCodeEffect>(), CodeReducer