package com.alife.anotherlife.ui.screen.registration.base.chain

import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import com.alife.core.chain.ChainHandler
import com.alife.domain.core.chain.BaseChainStateValidator
import com.alife.domain.core.chain.BooleanChainValidator

sealed interface RegChainValidator {

    class StateValidator(
        firstChain: BaseRegTextChain,
        secondChain: BaseRegTextChain,
    ) : BaseChainStateValidator<String, RegChainState>(
        firstChain,
        secondChain
    ), BaseRegTextChain, RegChainValidator

    class BooleanValidator(
        firstChain: ChainHandler.Base<String, Boolean>,
        secondChain: ChainHandler.Base<String, Boolean>,
    ) : BooleanChainValidator<String>(firstChain, secondChain), RegChainValidator
}