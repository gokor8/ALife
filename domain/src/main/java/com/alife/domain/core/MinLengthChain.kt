package com.alife.domain.core

import com.alife.core.chain.ChainHandler
import com.alife.core.chain.BaseChainState
import com.alife.core.chain.DefaultChainState

class MinLengthChain : ChainHandler.Base<String, BaseChainState> {

    override fun handle(inputModel: String): BaseChainState {
        return if(inputModel.isEmpty())
            DefaultChainState.Fail()
        else
            DefaultChainState.Success()
    }
}