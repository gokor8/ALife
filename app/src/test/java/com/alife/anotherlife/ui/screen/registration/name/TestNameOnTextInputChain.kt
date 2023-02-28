package com.alife.anotherlife.ui.screen.registration.name

import com.alife.anotherlife.ui.screen.registration.name.chain.AccessCharsNameTextChain
import com.alife.anotherlife.ui.screen.registration.name.chain.MaxNameTextChain
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TestNameOnTextInputChain {

    private val chainValidator = AccessCharsNameTextChain(MaxNameTextChain())

    @Test
    fun `test name chain success`() {
        val testString = listOf("Caliy Oleg", "Gregory", "Vlad Batayck", "Grigory Paravyannnnnnnnn")

        testString.forEach { string ->
            val actual = chainValidator.handle(string)

            val expected = true

            assertEquals(expected, actual)
        }
    }

    @Test
    fun `test name chain fail`() {
        val testString = listOf(
            "Caliy. Oleg",
            "+",
            " ",
            " Caliy",
            "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCaliy"
        )

        testString.forEach { string ->
            val actual = chainValidator.handle(string)

            val expected = false

            assertEquals(expected, actual)
        }
    }
}