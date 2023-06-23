package com.alife.anotherlife.core.ui

import com.alife.core.mvi.MVI

interface StateMapper<S : MVI.State, I, O> {

    fun map(state: S, inputModel: I): O
}