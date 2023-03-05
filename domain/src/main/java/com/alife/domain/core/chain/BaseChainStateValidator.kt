package com.alife.domain.core.chain

import com.alife.core.chain.BaseChainState
import com.alife.core.chain.ChainHandler
import com.alife.core.chain.ChainValidator

open class BaseChainStateValidator<I : Any, R : BaseChainState>(
    firstChain: ChainHandler.Base<I, R>,
    secondChain: ChainHandler.Base<I, R>,
) : ChainValidator<I, R>(firstChain, secondChain) {

    final override fun isSuccess(result: R): Boolean = result is BaseChainState.Success
}