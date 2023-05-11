package com.alife.anotherlife.ui.screen.registration.email_code.state

import com.alife.anotherlife.core.composable.text.code.state.CodeAction
import com.alife.anotherlife.ui.screen.registration.email_code.reducer.AbstractEmailCodeRegReducerBase
import com.alife.core.mvi.MVI

interface EmailCodeAction : MVI.Action {

    suspend fun onAction(emailCodeRegReducer: AbstractEmailCodeRegReducerBase)

    class CodeBoxAction(private val codeAction: CodeAction) : EmailCodeAction {

        override suspend fun onAction(emailCodeRegReducer: AbstractEmailCodeRegReducerBase) {
            codeAction.onAction(emailCodeRegReducer)
        }
    }
}