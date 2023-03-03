package com.alife.anotherlife.ui.text_formatter

import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList
import com.alife.anotherlife.core.composable.text.text_formation.mask.patterns.BirthdayPattern
import com.alife.anotherlife.core.composable.text.text_formation.mask.patterns.MaskPattern
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.BaseUnits
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.StaticUnits
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TestMaskBirthdayPattern {


    private lateinit var maskList: MaskList

    @Test
    fun `test full pattern get transformOffsetPosition`() {
        maskList = FakeFullBirthdayPatten().getMaskPattern()
        val originTransformPairs = listOf(
            Pair(0, 0), // first
            Pair(2, 2),
            Pair(3, 4),
            Pair(8, 10), // last
            Pair(9, 10) // out of range
        )
        // 12.12.2222

        originTransformPairs.forEach { originTransform ->

            val actual = maskList.toTransformOffsetPosition(originTransform.first)

            val expected = originTransform.second

            assertEquals(expected, actual)
        }
    }

    @Test
    fun `test empty pattern get transformOffsetPosition`() {
        maskList = BirthdayPattern().getMaskPattern() //Its Empty
        val originTransformPairs = listOf(
            Pair(0, 0), // first
            Pair(2, 0),
            Pair(3, 0),
            Pair(8, 0), // last
            Pair(9, 0) // out of range
        )
        // 12.12.2222

        originTransformPairs.forEach { originTransform ->

            val actual = maskList.toTransformOffsetPosition(originTransform.first)

            val expected = originTransform.second

            assertEquals(expected, actual)
        }
    }

    @Test
    fun `test not empty pattern get transformOffsetPosition`() {
        maskList = FakeNotEmptyBirthdayPatten().getMaskPattern()
        val originTransformPairs = listOf(
            Pair(0, 0), // first
            Pair(2, 2),
            Pair(3, 4),
            Pair(8, 4), // last
            Pair(9, 4) // out of range
        )
        // 12.12.2222

        originTransformPairs.forEach { originTransform ->

            val actual = maskList.toTransformOffsetPosition(originTransform.first)

            val expected = originTransform.second

            assertEquals(expected, actual)
        }
    }
}


// Test Realization
class FakeFullBirthdayPatten : MaskPattern {

    override fun getMaskPattern(): MaskList {
        return MaskList(
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
            StaticUnits.Dot(),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
            StaticUnits.Dot(),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t')
        )
    }
}

class FakeNotEmptyBirthdayPatten : MaskPattern {

    override fun getMaskPattern(): MaskList {
        return MaskList(
            BaseUnits.SymbolUnit('t'),
            BaseUnits.SymbolUnit('t'),
            StaticUnits.Dot(),
            BaseUnits.SymbolUnit('t'),
            BaseUnits.EmptyUnit(),
            StaticUnits.Dot(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit(),
            BaseUnits.EmptyUnit()
        )
    }
}