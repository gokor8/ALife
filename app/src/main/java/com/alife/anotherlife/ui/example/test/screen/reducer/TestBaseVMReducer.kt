package com.alife.anotherlife.ui.example.test.screen.reducer

import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenEffect
import com.alife.anotherlife.ui.example.test.screen.state.TestScreenState

abstract class TestBaseVMReducer : AbstractVMReducer<TestScreenState, TestScreenEffect>(), TestReducer