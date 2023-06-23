package com.alife.anotherlife.ui.screen.main.create_alife.model.timer

import androidx.compose.runtime.Stable

@Stable
interface BaseTimerUnit {

    fun time(): String


    abstract class Abstract(
        private val time: Long
    ) : BaseTimerUnit {
        override fun time() = "0:$time"
    }

    class Init : Abstract(15)

    class Default(time: Long) : Abstract(time)
}