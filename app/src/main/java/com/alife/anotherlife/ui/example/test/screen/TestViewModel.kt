package com.alife.anotherlife.ui.example.test.screen

import com.alife.anotherlife.core.ui.view_model.AbstractViewModel
import com.alife.anotherlife.ui.example.test.screen.reducer.TestScreenReducerBase
import com.alife.anotherlife.ui.example.test.screen.reducer.TestBaseVMReducer
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenAction
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenEffect
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenState

class TestViewModel(
    override val reducerVM: TestBaseVMReducer = TestScreenReducerBase()
) : AbstractViewModel<TestScreenAction, TestScreenState, TestScreenEffect>() {

    override suspend fun onAction(action: TestScreenAction) = action.onAction(reducerVM)
}