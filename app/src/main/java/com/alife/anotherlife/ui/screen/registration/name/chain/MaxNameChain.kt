package com.alife.anotherlife.ui.screen.registration.name.chain

import com.alife.anotherlife.R
import com.alife.core.chain.ChainHandler

class MaxNameChain : ChainHandler.Base<String, NameChainState> {

    override fun handle(inputModel: String): NameChainState {
        return if (inputModel.length > 25)
            NameChainState.Fail(R.string.error_more_25)
        else
            NameChainState.Success()
    }
}
