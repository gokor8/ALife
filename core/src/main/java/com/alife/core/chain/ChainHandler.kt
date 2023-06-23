package com.alife.core.chain

interface ChainHandler {

    interface Base<I, R> {
        fun handle(inputModel: I): R
    }

    interface BaseSuspend<I, R> {
        suspend fun handle(inputModel: I): R
    }

    interface Empty<R> {
        fun handle(): R
    }
}