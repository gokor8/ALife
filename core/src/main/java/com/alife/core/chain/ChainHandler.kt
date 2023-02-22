package com.alife.core.chain

sealed interface ChainHandler<R> {

    interface Base<I, R> {
        fun handle(inputModel: I): ChainStates<R>
    }

    interface Empty<R> {
        fun handle(): R
    }
}