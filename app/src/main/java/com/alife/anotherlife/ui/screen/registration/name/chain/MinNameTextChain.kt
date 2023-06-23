package com.alife.anotherlife.ui.screen.registration.name.chain

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import javax.inject.Inject

class MinNameTextChain @Inject constructor() : BaseRegTextChain {

    override fun handle(inputModel: String): RegChainState {
        return if (inputModel.length < 4)
            RegChainState.Fail(R.string.error_less_4)
        else
            RegChainState.Success()
    }
}