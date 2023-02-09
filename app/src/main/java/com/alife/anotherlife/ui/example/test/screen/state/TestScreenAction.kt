package com.alife.anotherlife.ui.example.test.screen.state

import com.alife.anotherlife.ui.example.test.custom_composable.action.ClickAction
import com.alife.anotherlife.ui.example.test.custom_composable.action.CustomAction
import com.alife.anotherlife.ui.example.test.custom_composable.action.TextCustomAction
import com.alife.anotherlife.ui.example.test.screen.reducer.TestReducer
import com.alife.core.mvi.MVI

interface TestScreenAction : MVI.Action {

    suspend fun onAction(testReducerReduce: TestReducer)
    class TestTextAction(private val text: String) : TestScreenAction {

        override suspend fun onAction(testReducerReduce: TestReducer) {
            testReducerReduce.onTestTextAction(text)
        }
    }

    class TestContinueClick : TestScreenAction {

        override suspend fun onAction(testReducerReduce: TestReducer) {
            testReducerReduce.onButtonClick()
        }
    }

    class TestBoxAction(private val action: CustomAction) : TestScreenAction {

        override suspend fun onAction(testReducerReduce: TestReducer) {
            //testReducerReduce.onCustomBoxAction(action)
            when(action) {
                is TextCustomAction -> testReducerReduce.onCustomTextBoxAction(action)
                is ClickAction -> testReducerReduce.onCustomClickBoxAction(action)
            }
        }
    }
}