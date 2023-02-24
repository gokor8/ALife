package com.alife.anotherlife.ui.screen.registration.name.chain

import com.alife.anotherlife.R
import com.alife.core.chain.ChainHandler

class MinNameChain : ChainHandler.Base<String, NameChainState> {

    override fun handle(inputModel: String): NameChainState {
        return if (inputModel.length < 4)
            NameChainState.Fail(R.string.error_less_4)
        else
            NameChainState.Success()
    }
}