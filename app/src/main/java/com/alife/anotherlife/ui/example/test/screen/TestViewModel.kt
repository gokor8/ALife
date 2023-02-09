package com.alife.anotherlife.ui.example.test.screen

import com.alife.anotherlife.core.ui.view_model.BaseViewModel
import com.alife.anotherlife.ui.example.test.screen.reducer.TestScreenReducer
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenAction
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenEffect
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenState

class TestViewModel : BaseViewModel<TestScreenAction, TestScreenState, TestScreenEffect>() {

    override val reducerVM = TestScreenReducer()

    override suspend fun onAction(action: TestScreenAction) = action.onAction(reducerVM)
}