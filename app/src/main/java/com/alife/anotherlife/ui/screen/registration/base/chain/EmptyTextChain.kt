package com.alife.anotherlife.ui.screen.registration.base.chain

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.ChainState
import javax.inject.Inject

class EmptyTextChain @Inject constructor(): BaseRegTextChain {

    override fun handle(inputModel: String): ChainState {
        return if (inputModel.isEmpty())
            ChainState.Fail(R.string.error_empty)
        else
            ChainState.Success()
    }
}