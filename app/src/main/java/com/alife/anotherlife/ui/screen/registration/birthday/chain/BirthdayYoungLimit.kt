package com.alife.anotherlife.ui.screen.registration.birthday.chain

import com.alife.anotherlife.R
import java.util.*
import javax.inject.Inject

class BirthdayYoungLimit @Inject constructor() : BirthdayOldLimitChain(
    Calendar.getInstance().time,
    R.string.so_young
) {
    override fun condition(inputModel: Date): Boolean = inputModel <= limitationDate
}