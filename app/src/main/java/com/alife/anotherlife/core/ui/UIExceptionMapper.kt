package com.alife.anotherlife.core.ui

import com.alife.core.mvi.MVI
import java.lang.Exception

interface UIExceptionMapper<S : MVI.State> {

    fun map(state: S, exception: Exception): S
}