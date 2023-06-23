package com.alife.anotherlife.ui.screen.main.create_alife.model.timer

import android.os.CountDownTimer
import java.util.concurrent.TimeUnit

class CreateAlifeCountDownTimer(
    private val onTick: (BaseTimerUnit) -> Unit,
    private val onEnd: () -> Unit
) : CountDownTimer(
    TimeUnit.SECONDS.toMillis(15),
    TimeUnit.SECONDS.toMillis(1)
) {

    constructor(timerCallback: CreateAlifeTimerCallback) : this(
        timerCallback::onTick,
        timerCallback::onEndTimer
    )

    override fun onTick(millisUntilFinished: Long) {
        onTick(
            BaseTimerUnit.Default(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished))
        )
    }

    override fun onFinish() {
        onEnd()
    }
}