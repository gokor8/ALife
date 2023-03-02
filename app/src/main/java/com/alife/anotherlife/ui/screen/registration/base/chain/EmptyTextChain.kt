package com.alife.anotherlife.ui.screen.registration.base.chain

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import javax.inject.Inject

class EmptyTextChain @Inject constructor(): BaseRegTextChain {

    override fun handle(inputModel: String): RegChainState {
        return if (inputModel.isEmpty())
            RegChainState.Fail(R.string.error_empty)
        else
            RegChainState.Success()
    }
}