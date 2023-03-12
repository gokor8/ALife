package com.alife.anotherlife.ui.screen.registration.base.chain

import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import com.alife.core.chain.ChainHandler

abstract class DefaultRegChain<I : Any> (
    private val onErrorResId: Int
) : ChainHandler.Base<I, RegChainState> {

    abstract fun condition(inputModel: I): Boolean

    override fun handle(inputModel: I): RegChainState {
        return if (condition(inputModel))
            RegChainState.Success()
        else
            RegChainState.Fail(onErrorResId)
    }
}