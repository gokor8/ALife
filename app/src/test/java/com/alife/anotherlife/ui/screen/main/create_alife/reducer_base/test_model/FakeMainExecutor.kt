package com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model

import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import java.util.concurrent.Executor

class FakeMainExecutor(private val executor: Executor?) : BaseContextMainExecutorWrapper {
    override fun getMainExecutor() = executor
}