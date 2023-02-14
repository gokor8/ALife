package com.alife.core.mvi

sealed interface MVIReducer<I : MVI.Action> {

    interface Base<I : MVI.Action> : MVIReducer<I> {
        fun reduce(action: I)
    }

    interface Suspend<I : MVI.Action> : MVIReducer<I> {
        suspend fun reduce(action: I)
    }
}