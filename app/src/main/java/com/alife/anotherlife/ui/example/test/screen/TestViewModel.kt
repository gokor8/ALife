package com.alife.anotherlife.ui.example.test.screen

import com.alife.anotherlife.core.ui.view_model.BaseViewModel
import com.alife.anotherlife.ui.example.test.screen.reducer.TestReducer
import com.alife.anotherlife.ui.example.test.screen.reducer.TestScreenReducer
import com.alife.anotherlife.ui.example.test.screen.reducer.TestVMReducer
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenAction
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenEffect
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenState
import dagger.hilt.android.lifecycle.HiltViewModel

class TestViewModel(
    override val reducerVM: TestVMReducer = TestScreenReducer()
) : BaseViewModel<TestScreenAction, TestScreenState, TestScreenEffect>() {

    override suspend fun onAction(action: TestScreenAction) = action.onAction(reducerVM)
}