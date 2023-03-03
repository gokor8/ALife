package com.alife.anotherlife.ui.text_formatter

import com.alife.anotherlife.core.composable.text.text_formation.base.MaskTextFormatter
import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList
import com.alife.anotherlife.core.composable.text.text_formation.mask.patterns.PhonePattern
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class TestNumberMaskTextFormatter {

    private lateinit var maskList: MaskList
    private val maskTextFormatter = MaskTextFormatter()


    @Before
    fun before() {
        maskList = PhonePattern().getMaskPattern()
    }

    @Test
    fun `test empty text format`() {
        val testText = ""

        val actual = maskTextFormatter.format(testText, maskList)

        val expected = "+7"

        assertEquals(expected, actual)
    }

    @Test
    fun `test not empty text format`() {
        val testText = "989535"

        val actual = maskTextFormatter.format(testText, maskList)

        val expected = "+7 989 535"

        assertEquals(expected, actual)
    }

    @Test
    fun `test not empty text with change format`() {
        maskTextFormatter.format("989535", maskList)

        val changedText = "98935"

        val actual = maskTextFormatter.format(changedText, maskList)

        val expected = "+7 989 35"

        assertEquals(expected, actual)
    }

    @Test
    fun `test full fill text format`() {
        val testText = "9895354251"

        val actual = maskTextFormatter.format(testText, maskList)

        val expected = "+7 989 535-42-51"

        assertEquals(actual, expected)
    }
}