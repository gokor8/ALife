package com.alife.anotherlife.core.composable.text.code.state

import com.alife.anotherlife.core.composable.text.code.CodeReducer
import com.alife.core.mvi.MVI

interface CodeAction : MVI.Action {

    suspend fun onAction(reducer: CodeReducer)


    class CodeInput(private val code: String) : CodeAction {

        override suspend fun onAction(reducer: CodeReducer) {
            reducer.onCode(code)
        }
    }
}