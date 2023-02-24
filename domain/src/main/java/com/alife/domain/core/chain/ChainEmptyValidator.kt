package com.alife.domain.core.chain

import com.alife.core.chain.ChainHandler
import com.alife.core.chain.EmptyChainState

class ChainEmptyValidator<I>(
    private val first: ChainHandler.Base<I, EmptyChainState>,
    private val second: ChainHandler.Base<I, EmptyChainState>,
) : ChainHandler.Base<I, EmptyChainState> {

    override fun handle(inputModel: I): EmptyChainState {
        return when (val chainState = first.handle(inputModel)) {
            is EmptyChainState.Success -> second.handle(inputModel)
            is EmptyChainState.Fail -> chainState
        }
    }
}