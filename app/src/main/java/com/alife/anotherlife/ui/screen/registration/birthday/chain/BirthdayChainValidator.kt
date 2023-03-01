package com.alife.anotherlife.ui.screen.registration.birthday.chain

import com.alife.anotherlife.ui.screen.registration.base.chain.base.ChainState
import javax.inject.Inject

class BirthdayChainValidator @Inject constructor(
    private val birthdayDateTextChain: BirthdayDateTextChain,
    private val birthdayYearLimit: BirthdayYearLimit,
) : BirthdayTextChain {

    override fun handle(inputModel: String): ChainState {
        val chainState = birthdayDateTextChain.handle(inputModel)

        return if (chainState is DateSuccessChainState)
            birthdayYearLimit.handle(chainState.inputModel)
        else
            chainState
    }
}