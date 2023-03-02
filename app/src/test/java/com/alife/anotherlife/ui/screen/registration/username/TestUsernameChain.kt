package com.alife.anotherlife.ui.screen.registration.username

import com.alife.anotherlife.ui.screen.registration.name.chain.FirstIsLetterTextChain
import com.alife.anotherlife.ui.screen.registration.username.chain.AccessCharsUsernameTextChain
import com.alife.anotherlife.ui.screen.registration.username.chain.UsernameMaxTextChain
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TestUsernameChain {

    private val usernameChain = AccessCharsUsernameTextChain(
        charArrayOf('.'),
        UsernameMaxTextChain(),
        FirstIsLetterTextChain()
    )

    @Test
    fun `test success chain`() {
        val testData = listOf("aboba", "Aboba1", "aboba.")

        testData.forEach { testString ->
            val actual = usernameChain.handle(testString)

            val expected = true

            assertEquals(expected, actual)
        }
    }

    @Test
    fun `test fail chain`() {
        val testData = listOf(" aboba", "1aboba", "aboba ", ".aboba")

        testData.forEach { testString ->
            val actual = usernameChain.handle(testString)

            val expected = false

            assertEquals(expected, actual)
        }
    }
}