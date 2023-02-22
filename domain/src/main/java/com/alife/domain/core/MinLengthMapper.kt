package com.alife.domain.core

import com.alife.core.chain.ChainHandler
import com.alife.core.chain.ChainStates

class MinLengthMapper : ChainHandler.Base<String, Nothing> {

    override fun handle(inputModel: String): ChainStates<Nothing> {
        return if(inputModel.isEmpty())
            ChainStates.Success()
        else
            ChainStates.Fail()
    }
}