package com.alife.anotherlife.ui.screen.main.create_alife.addons

import android.content.Context
import java.util.concurrent.Executor

interface BaseContextMainExecutorWrapper {

    fun getContext(): Context?

    fun getMainExecutor(): Executor?
}