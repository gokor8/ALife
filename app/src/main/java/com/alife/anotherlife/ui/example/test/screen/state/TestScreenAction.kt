package com.alife.anotherlife.ui.example.test.screen.state

import com.alife.anotherlife.ui.example.test.custom_composable.TextsAction
import com.alife.anotherlife.ui.example.test.screen.reducer.TestReducer
import com.alife.core.mvi.MVI

interface TestScreenAction : MVI.Action {

    fun onAction(testReducerReduce: TestReducer)
    class TestTextAction(private val text: String) : TestScreenAction {
        override fun onAction(testReducerReduce: TestReducer) {
            testReducerReduce.onTestTextAction(text)
        }
    }
    class TestContinueClick : TestScreenAction {
        override fun onAction(testReducerReduce: TestReducer) {
            testReducerReduce.onContinueClick()
        }
    }

    class TestBoxAction(private val action: TextsAction) : TestScreenAction {
        override fun onAction(testReducerReduce: TestReducer) {
            testReducerReduce.onTestBoxAction(action)
        }
    }
}