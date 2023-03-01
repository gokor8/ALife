package com.alife.anotherlife.ui.screen.registration.birthday

import com.alife.anotherlife.ui.screen.registration.base.chain.base.ChainState
import com.alife.anotherlife.ui.screen.registration.birthday.chain.BirthdayChainValidator
import com.alife.anotherlife.ui.screen.registration.birthday.chain.BirthdayDateTextChain
import com.alife.anotherlife.ui.screen.registration.birthday.chain.BirthdayTextChain
import com.alife.anotherlife.ui.screen.registration.birthday.chain.BirthdayYearLimit
import com.alife.core.chain.ChainHandler
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test
import java.util.*

class TestBirthdayOnTextInputChain {

    private val birthdayOnTextInputChain: BirthdayTextChain = BirthdayChainValidator(
        BirthdayDateTextChain(Locale.UK),
        BirthdayYearLimit()
    )

    @Test
    fun `test success`() {
        val testData = listOf("11.11.2011", "02.02.2023", "03.02.1945")

        testData.map { it.replace(".", "") }.forEach { date ->
            val actual = birthdayOnTextInputChain.handle(date)

            assertTrue(actual is ChainState.Success)
        }
    }

    @Test
    fun `test fail`() {
        val testData = listOf("11.11.1111", "42.02.2023", "02.42.2023", "02.02.2222", "02.02.1944")

        testData.map { it.replace(".", "") }.forEach { date ->
            val actual = birthdayOnTextInputChain.handle(date)

            assertTrue(actual is ChainState.Fail)
        }
    }
}