package com.alife.anotherlife.ui.screen.registration.name.chain

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.ChainState
import javax.inject.Inject

class MaxNameTextChain @Inject constructor() : BaseRegTextChain {

    override fun handle(inputModel: String): ChainState {
        return if (inputModel.length > 25)
            ChainState.Fail(R.string.error_more_25)
        else
            ChainState.Success()
    }
}
