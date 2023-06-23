package com.alife.anotherlife.ui.screen.registration.birthday.chain

import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import com.alife.core.chain.ChainHandler
import java.util.Date
import javax.inject.Inject

class BirthdayChainValidator @Inject constructor(
    private val birthdayDateTextChain: BirthdayDateTextChain,
    private val birthdayYearGafferLimit: ChainHandler.Base<Date, RegChainState>,
) : BirthdayTextChain {

    override fun handle(inputModel: String): RegChainState {
        val chainState = birthdayDateTextChain.handle(inputModel)

        return if (chainState is DateSuccessRegChainState)
            birthdayYearGafferLimit.handle(chainState.inputModel)
        else
            chainState
    }
}