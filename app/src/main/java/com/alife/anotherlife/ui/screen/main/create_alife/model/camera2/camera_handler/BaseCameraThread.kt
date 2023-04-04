package com.alife.anotherlife.ui.screen.main.create_alife.model.camera2.camera_handler

import android.os.Handler
import android.os.HandlerThread

abstract class BaseCameraThread(private val threadName: String) {

    private val backgroundThread by lazy { HandlerThread(threadName).apply { start() } }
    val handler by lazy { Handler(backgroundThread.looper) }

    fun finish() {
        backgroundThread.quitSafely()
        backgroundThread.join()
    }
}