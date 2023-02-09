package com.alife.core.mvi

interface MVIMapper<ACTION : MVI.Action, O> {

    fun reduce(action: ACTION, model: O): O
}