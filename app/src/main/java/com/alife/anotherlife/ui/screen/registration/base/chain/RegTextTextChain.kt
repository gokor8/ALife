package com.alife.anotherlife.ui.screen.registration.base.chain

import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import javax.inject.Inject

class RegTextTextChain @Inject constructor(
    private val firstChain: BaseRegTextChain,
    private val secondChain: BaseRegTextChain
): BaseRegTextChain {

    override fun handle(inputModel: String): RegChainState {
        val chainResult = firstChain.handle(inputModel)

        return if(chainResult is RegChainState.Success)
            secondChain.handle(inputModel)
        else
            chainResult
    }
}