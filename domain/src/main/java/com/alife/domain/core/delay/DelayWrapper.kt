package com.alife.domain.core.delay

import kotlinx.coroutines.delay

abstract class DelayWrapper(private val delayTime: Int) {

    suspend fun delay() = delay(delayTime.toLong())


    class Short : DelayWrapper(1500)

    class Long : DelayWrapper(2500)
}