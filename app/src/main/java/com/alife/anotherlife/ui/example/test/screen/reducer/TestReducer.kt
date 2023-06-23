package com.alife.anotherlife.ui.example.test.screen.reducer

import com.alife.anotherlife.ui.example.test.custom_composable.action.ClickAction
import com.alife.anotherlife.ui.example.test.custom_composable.action.TextCustomAction
import com.alife.anotherlife.ui.example.test.custom_composable.reduce.ClickReduce

interface TestReducer : ClickReduce {

    suspend fun onTestTextAction(text: String)

    suspend fun onButtonClick()

    //fun onCustomBoxAction(customAction: CustomAction)

    suspend fun onCustomTextBoxAction(textAction: TextCustomAction)

    suspend fun onCustomClickBoxAction(clickAction: ClickAction)
    override suspend fun onContinueClick()

}