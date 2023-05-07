package com.alife.anotherlife.ui.screen.main.create_alife.model.timer

import android.os.CountDownTimer

class CreateAlifeVideoTimer(
    private val timer: CountDownTimer
) : BaseTimer {

    fun start() {
        timer.start()
    }

    fun stop() {
        timer.onFinish()
        timer.cancel()
    }
}