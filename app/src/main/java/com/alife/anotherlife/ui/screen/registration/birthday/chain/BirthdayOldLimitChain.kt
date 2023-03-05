package com.alife.anotherlife.ui.screen.registration.birthday.chain

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.registration.base.chain.DefaultRegChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import com.alife.core.chain.ChainHandler
import java.util.*
import javax.inject.Inject

sealed class BirthdayOldLimitChain(
    protected val limitationDate: Date,
    onErrorResId: Int
) : DefaultRegChain<Date>(onErrorResId) {

    class BirthdayYearGafferLimit @Inject constructor() : BirthdayOldLimitChain(
        Calendar.getInstance().apply { set(1945, 1, 2) }.time,
        R.string.gaffer
    ) { override fun condition(inputModel: Date): Boolean = inputModel > limitationDate }

    class BirthdayYoungLimit @Inject constructor() : BirthdayOldLimitChain(
        Calendar.getInstance().time,
        R.string.so_young
    ) { override fun condition(inputModel: Date): Boolean = inputModel <= limitationDate }
}