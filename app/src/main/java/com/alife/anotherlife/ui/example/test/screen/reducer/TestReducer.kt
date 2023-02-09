package com.alife.anotherlife.ui.example.test.screen.reducer

import com.alife.anotherlife.ui.example.test.custom_composable.TextsAction

interface TestReducer {

    fun onTestTextAction(text: String)

    fun onContinueClick()

    fun onTestBoxAction(textAction: TextsAction)
}