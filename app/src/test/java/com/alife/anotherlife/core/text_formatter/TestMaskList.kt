package com.alife.anotherlife.core.text_formatter

import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList
import com.alife.anotherlife.core.composable.text.text_formation.mask.patterns.BirthdayPattern
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.BaseUnits
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.StaticUnits
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class TestMaskList {

    private lateinit var maskList: MaskList

    @Before
    fun before() {
        maskList = MaskList(
            StaticUnits.Plus(),
            BaseUnits.EmptyUnit(),
            StaticUnits.Separator(),
            BaseUnits.EmptyUnit()
        )
    }

    @Test
    fun `test get not empty units count`() {
        val testListOffsets = listOf(0, 1, 2, 3, 4)

        testListOffsets.forEach { offset ->
            val actual = maskList.notEmptyUnitCount(offset)

            val expected = 1

            assertEquals(actual, expected)
        }
    }

    @Test
    fun `test get not empty units count with full`() {
        maskList = BirthdayPattern().birthdayTestMask
        // 12.12.2222

        val testListOffsets = listOf(Pair(0, 1), Pair(1, 2), Pair(2, 3), Pair(3, 4))

        testListOffsets.forEach { offset ->
            val actual = maskList.notEmptyUnitCount(offset.first)

            val expected = offset.second

            assertEquals(actual, expected)
        }
    }

}