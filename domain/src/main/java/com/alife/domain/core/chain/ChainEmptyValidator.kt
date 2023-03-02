package com.alife.domain.core.chain

import com.alife.core.chain.ChainHandler
import com.alife.core.chain.BaseChainState

class ChainEmptyValidator<I>(
    private val first: ChainHandler.Base<I, BaseChainState>,
    private val second: ChainHandler.Base<I, BaseChainState>,
) : ChainHandler.Base<I, BaseChainState> {

    override fun handle(inputModel: I): BaseChainState {
        return when (val chainState = first.handle(inputModel)) {
            is BaseChainState.Success -> second.handle(inputModel)
            else -> chainState
        }
    }
}