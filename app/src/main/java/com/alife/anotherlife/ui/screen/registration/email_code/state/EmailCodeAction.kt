package com.alife.anotherlife.ui.screen.registration.email_code.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.core.composable.text.code.state.CodeAction
import com.alife.anotherlife.ui.screen.registration.email_code.reducer.AbstractEmailCodeRegReducerBase
import com.alife.core.mvi.MVI
import com.alife.core.mvi.addons.BaseMVIHandlers

interface EmailCodeAction : BaseMVIAction<AbstractEmailCodeRegReducerBase> {

    class CodeBoxAction(private val codeAction: CodeAction) : EmailCodeAction {

        override suspend fun onAction(emailCodeRegReducer: AbstractEmailCodeRegReducerBase) {
            codeAction.onAction(emailCodeRegReducer)
        }
    }
}