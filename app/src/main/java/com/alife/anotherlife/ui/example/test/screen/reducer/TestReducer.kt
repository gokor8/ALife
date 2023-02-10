package com.alife.anotherlife.ui.example.test.screen.reducer

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.reducer.VMReducer
import com.alife.anotherlife.ui.example.test.custom_composable.action.ClickAction
import com.alife.anotherlife.ui.example.test.custom_composable.action.TextCustomAction
import com.alife.anotherlife.ui.example.test.custom_composable.reduce.ClickReduce
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenEffect
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenState

interface TestReducer : ClickReduce {

    suspend fun onTestTextAction(text: String)

    suspend fun onButtonClick()

    //fun onCustomBoxAction(customAction: CustomAction)

    suspend fun onCustomTextBoxAction(textAction: TextCustomAction)

    suspend fun onCustomClickBoxAction(clickAction: ClickAction)
    override suspend fun onContinueClick()

}