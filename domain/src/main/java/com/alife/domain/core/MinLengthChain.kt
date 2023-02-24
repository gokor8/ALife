package com.alife.domain.core

import com.alife.core.chain.ChainHandler
import com.alife.core.chain.EmptyChainState

class MinLengthChain : ChainHandler.Base<String, EmptyChainState> {

    override fun handle(inputModel: String): EmptyChainState {
        return if(inputModel.isEmpty())
            EmptyChainState.Fail()
        else
            EmptyChainState.Success()
    }
}