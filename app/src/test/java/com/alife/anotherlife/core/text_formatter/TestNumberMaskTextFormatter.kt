package com.alife.anotherlife.core.text_formatter

import com.alife.anotherlife.core.composable.text.text_formation.base.MaskTextFormatter
import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.BaseUnits
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.StaticUnits
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class TestNumberMaskTextFormatter {

    private lateinit var maskList: MaskList
    private val maskTextFormatter = MaskTextFormatter()


    @Before
    fun before() {
        maskList = MaskList(
            StaticUnits.Plus(),
            StaticUnits.RusCode(),
            StaticUnits.Space(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
            StaticUnits.Separator(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
            StaticUnits.Separator(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
            StaticUnits.Separator(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
        )
    }

    @Test
    fun `test empty text format`() {
        val testText = ""

        val actual = maskTextFormatter.format(testText, maskList)

        val expected = "+7 "

        assertEquals(actual, expected)
    }

    @Test
    fun `test not empty text format`() {
        val testText = "989535"

        val actual = maskTextFormatter.format(testText, maskList)

        val expected = "+7 989-535-"

        assertEquals(actual, expected)
    }

    @Test
    fun `test full fill text format`() {
        val testText = "9895354251"

        val actual = maskTextFormatter.format(testText, maskList)

        val expected = "+7 989-535-42-51"

        assertEquals(actual, expected)
    }
}