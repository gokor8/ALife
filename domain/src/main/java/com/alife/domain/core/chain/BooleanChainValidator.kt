package com.alife.domain.core.chain

import com.alife.core.chain.ChainHandler
import com.alife.core.chain.ChainValidator

abstract class BooleanChainValidator<I : Any>(
    firstChain: ChainHandler.Base<I, Boolean>,
    secondChain: ChainHandler.Base<I, Boolean>,
) : ChainValidator<I, Boolean>(firstChain, secondChain) {

    final override fun isSuccess(result: Boolean) = result
}