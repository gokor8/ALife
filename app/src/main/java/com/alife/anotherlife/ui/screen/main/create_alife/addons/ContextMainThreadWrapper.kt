package com.alife.anotherlife.ui.screen.main.create_alife.addons

import android.content.Context
import androidx.core.content.ContextCompat
import java.lang.ref.WeakReference
import java.util.concurrent.Executor

class ContextMainThreadWrapper(private val context: WeakReference<Context>) {

    fun getMainExecutor(): Executor? = context.get()?.let { ContextCompat.getMainExecutor(it) }
}