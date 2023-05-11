package com.alife.anotherlife.ui.screen.main.create_alife.model.timer

interface CreateAlifeTimerCallback {

    fun onTick(newTimerUnit: BaseTimerUnit)

    fun onEndTimer()
}