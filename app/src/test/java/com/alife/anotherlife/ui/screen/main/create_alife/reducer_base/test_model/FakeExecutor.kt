package com.alife.anotherlife.ui.screen.main.create_alife.reducer_base.test_model

import java.util.concurrent.Executor

class FakeExecutor : Executor {
    override fun execute(command: Runnable?) {}
}