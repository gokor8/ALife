package com.alife.domain.core.delay

import kotlinx.coroutines.delay

abstract class DelayWrapper(private val delayTime: Int) {

    suspend fun delay() = delay(delayTime.toLong())


    class Short : DelayWrapper(2000)

    class Medium : DelayWrapper(3500)

    class Long : DelayWrapper(5000)
}