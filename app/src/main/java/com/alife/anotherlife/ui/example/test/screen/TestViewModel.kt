package com.alife.anotherlife.ui.example.test.screen

import com.alife.anotherlife.core.ui.view_model.AbstractViewModel
import com.alife.anotherlife.ui.example.test.screen.reducer.TestScreenReducer
import com.alife.anotherlife.ui.example.test.screen.reducer.TestVMReducer
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenAction
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenEffect
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenState

class TestViewModel(
    override val reducerVM: TestVMReducer = TestScreenReducer()
) : AbstractViewModel<TestScreenAction, TestScreenState, TestScreenEffect>() {

    override suspend fun onAction(action: TestScreenAction) = action.onAction(reducerVM)
}