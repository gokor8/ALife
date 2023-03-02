package com.alife.anotherlife.ui.screen.registration.birthday.chain

import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import com.alife.core.chain.ChainHandler
import java.util.*

abstract class BirthdayOldLimitChain(
    protected val limitationDate: Date,
    private val onErrorResId: Int
) : ChainHandler.Base<Date, RegChainState> {

    abstract fun condition(inputModel: Date): Boolean

    override fun handle(inputModel: Date): RegChainState {
        return if (condition(inputModel))
            RegChainState.Success()
        else
            RegChainState.Fail(onErrorResId)
    }
}