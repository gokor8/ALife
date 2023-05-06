package com.alife.anotherlife.ui.screen.main.create_alife.addons

import java.util.concurrent.Executor

interface BaseContextMainExecutorWrapper : CustomContextWrapper {

    fun getMainExecutor(): Executor // TODO может выкидывать ошибку проще?
}