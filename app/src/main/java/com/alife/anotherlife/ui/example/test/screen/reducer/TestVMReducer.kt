package com.alife.anotherlife.ui.example.test.screen.reducer

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.reducer.VMReducer
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenEffect
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenState

abstract class TestVMReducer : BaseVMReducer<TestScreenState, TestScreenEffect>(), TestReducer