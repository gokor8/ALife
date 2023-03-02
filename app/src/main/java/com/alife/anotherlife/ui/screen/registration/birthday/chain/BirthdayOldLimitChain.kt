package com.alife.anotherlife.ui.screen.registration.birthday.chain

import com.alife.anotherlife.ui.screen.registration.base.chain.DefaultRegChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import com.alife.core.chain.ChainHandler
import java.util.*

abstract class BirthdayOldLimitChain(
    protected val limitationDate: Date,
    onErrorResId: Int
) : DefaultRegChain<Date>(onErrorResId)