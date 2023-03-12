package com.alife.anotherlife.ui.text_formatter

import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList
import com.alife.anotherlife.core.composable.text.text_formation.mask.patterns.MaskPattern
import com.alife.anotherlife.core.composable.text.text_formation.mask.patterns.PhonePattern
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.BaseUnits
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.StaticUnits
import junit.framework.TestCase
import org.junit.Test

class TestMaskPhonePattern {

    private lateinit var maskList: MaskList

    @Test
    fun `test full pattern get transformOffsetPosition`() {
        maskList = FakeFullPhonePatten().getMaskPattern()
        val originTransformPairs = listOf(
            Pair(0, 0), // first
            Pair(1, 4),
            Pair(3, 6),
            Pair(4, 8),
            Pair(7, 12),
            Pair(10, 16), // last
            Pair(11, 16) // out of range
        )
        // 12.12.2222

        originTransformPairs.forEach { originTransform ->

            val actual = maskList.toTransformOffsetPosition(originTransform.first)

            val expected = originTransform.second

            TestCase.assertEquals(expected, actual)
        }
    }

    @Test
    fun `test empty pattern get transformOffsetPosition`() {
        maskList = PhonePattern().getMaskPattern()
        val originTransformPairs = listOf(
            Pair(0, 0), // first
            Pair(1, 3),
            Pair(3, 3),
            Pair(4, 3),
            Pair(7, 3),
            Pair(10, 3), // last
            Pair(11, 3) // out of range
        )
        // 12.12.2222

        originTransformPairs.forEach { originTransform ->

            val actual = maskList.toTransformOffsetPosition(originTransform.first)

            val expected = originTransform.second

            TestCase.assertEquals(expected, actual)
        }
    }

    @Test
    fun `test not empty pattern get transformOffsetPosition`() {
        maskList = FakeNotEmptyPhonePatten().getMaskPattern()
        val originTransformPairs = listOf(
            Pair(0, 0), // first
            Pair(1, 4),
            Pair(3, 6),
            Pair(4, 8),
            Pair(7, 9),
            Pair(10, 9), // last
            Pair(11, 9) // out of range
        )
        // 12.12.2222

        originTransformPairs.forEach { originTransform ->

            val actual = maskList.toTransformOffsetPosition(originTransform.first)

            val expected = originTransform.second

            TestCase.assertEquals(expected, actual)
        }
    }

    @Test
    fun `test full patter get origin`() {

    }
}


// Test Realization
class FakeFullPhonePatten : MaskPattern {

    override fun getMaskPattern(): MaskList {
        return MaskList(
            StaticUnits.Plus(),
            StaticUnits.RusCode(),
            StaticUnits.Space(),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
            StaticUnits.Space(),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
            StaticUnits.Separator(),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
            StaticUnits.Separator(),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
        )
    }
}

class FakeNotEmptyPhonePatten : MaskPattern {

    override fun getMaskPattern(): MaskList {
        return MaskList(
            StaticUnits.Plus(),
            StaticUnits.RusCode(),
            StaticUnits.Space(),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
            StaticUnits.Space(),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.EmptyUnit(),
            StaticUnits.Separator(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
            StaticUnits.Separator(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit()
        )
    }
}