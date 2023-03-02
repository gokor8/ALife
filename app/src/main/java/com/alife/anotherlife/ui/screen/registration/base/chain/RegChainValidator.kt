package com.alife.anotherlife.ui.screen.registration.base.chain

import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import com.alife.core.chain.ChainValidator

class RegChainValidator(
    firstChain: BaseRegTextChain,
    secondChain: BaseRegTextChain,
) : ChainValidator<String, RegChainState>(firstChain, secondChain), BaseRegTextChain