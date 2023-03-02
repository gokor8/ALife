package com.alife.core.chain

open class ChainValidator<I, R : BaseChainState>(
    private val firstChain: ChainHandler.Base<I, R>,
    private val secondChain: ChainHandler.Base<I, R>,
) : ChainHandler.Base<I, R> {

    override fun handle(inputModel: I): R {
        val actual = firstChain.handle(inputModel)

        return if(actual is BaseChainState.Success) {
            secondChain.handle(inputModel)
        } else {
            actual
        }
    }
}