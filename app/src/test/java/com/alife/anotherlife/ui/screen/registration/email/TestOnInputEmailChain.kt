package com.alife.anotherlife.ui.screen.registration.email

import com.alife.anotherlife.ui.screen.registration.email.chain.EmailInputChain
import com.alife.anotherlife.ui.screen.registration.name.chain.FirstIsLetterTextChain
import junit.framework.TestCase
import org.junit.Test

class TestOnInputEmailChain {

    private val emailChain = EmailInputChain(
        charArrayOf('.', '@'),
        FirstIsLetterTextChain()
    )

    @Test
    fun `test success chain`() {
        val testData = listOf("aboba.", "Aboba@", "aboba1.@", "aboba@.", "aboba1@.aboba")

        testData.forEach { testString ->
            val actual = emailChain.handle(testString)

            val expected = true

            TestCase.assertEquals(expected, actual)
        }
    }

    @Test
    fun `test fail chain`() {
        val testData = listOf(" aboba", "1aboba", "aboba@ ", ".aboba", "@aboba")

        testData.forEach { testString ->
            val actual = emailChain.handle(testString)

            val expected = false

            TestCase.assertEquals(expected, actual)
        }
    }
}