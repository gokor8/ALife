package com.alife.anotherlife.ui.screen.main.create_alife.addons

import java.util.concurrent.Executor

interface BaseContextMainExecutorWrapper {

    fun getMainExecutor(): Executor?
}