package com.alife.core.chain

abstract class ChainValidator<I, R>(
    private val firstChain: ChainHandler.Base<I, R>,
    private val secondChain: ChainHandler.Base<I, R>,
) : ChainHandler.Base<I, R> {

    abstract fun isSuccess(result: R): Boolean

    override fun handle(inputModel: I): R {
        val actual = firstChain.handle(inputModel)

        return if(isSuccess(actual)) {
            secondChain.handle(inputModel)
        } else {
            actual
        }
    }
}