package com.alife.anotherlife.ui.screen.registration.birthday.chain

import com.alife.anotherlife.R
import java.util.*
import javax.inject.Inject

class BirthdayYearGafferLimit @Inject constructor() : BirthdayOldLimitChain(
    Calendar.getInstance().apply { set(1945, 1, 2) }.time,
    R.string.gaffer
) {
    override fun condition(inputModel: Date): Boolean = inputModel > limitationDate
}