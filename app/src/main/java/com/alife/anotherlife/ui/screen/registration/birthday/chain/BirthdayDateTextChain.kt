package com.alife.anotherlife.ui.screen.registration.birthday.chain

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.registration.base.chain.base.ChainState
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class BirthdayDateTextChain @Inject constructor(private val locale: Locale) : BirthdayTextChain {

    private val dateStringPattern = "ddMMyyyy"

    override fun handle(inputModel: String): ChainState {
        val format = SimpleDateFormat(dateStringPattern, locale)

        return try {
            val date = format.parse(inputModel)

            DateSuccessChainState(date)
        } catch (e: ParseException) {
            e.printStackTrace()

            ChainState.Fail(R.string.invalid_birthday)
        }
    }
}