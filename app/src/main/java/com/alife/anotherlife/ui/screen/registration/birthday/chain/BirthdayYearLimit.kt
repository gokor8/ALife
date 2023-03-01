package com.alife.anotherlife.ui.screen.registration.birthday.chain

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.registration.base.chain.base.ChainState
import com.alife.core.chain.ChainHandler
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class BirthdayYearLimit @Inject constructor() : ChainHandler.Base<Date, ChainState> {

    private val limitationDate = Calendar.getInstance().apply { set(1945, 1, 2) }

    override fun handle(inputModel: Date): ChainState {
        return if (inputModel > limitationDate.time)
            ChainState.Success()
        else
            ChainState.Fail(R.string.gaffer)
    }
}