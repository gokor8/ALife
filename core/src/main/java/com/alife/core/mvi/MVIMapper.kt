package com.alife.core.mvi

interface MVIMapper<ACTION : MVI.Action, O> {

    suspend fun reduce(action: ACTION, model: O): O
}