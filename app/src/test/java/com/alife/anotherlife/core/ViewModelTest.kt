package com.alife.anotherlife.core

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Rule

abstract class ViewModelTest @ExperimentalCoroutinesApi constructor(
    testDispatcher: TestDispatcher = UnconfinedTestDispatcher() //StandardTestDispatcher()
) {

    @get:Rule
    val mainDispatcherRule = VMDispatcherRule(testDispatcher)
}