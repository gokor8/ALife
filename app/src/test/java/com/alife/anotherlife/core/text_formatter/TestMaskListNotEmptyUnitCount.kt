package com.alife.anotherlife.core.text_formatter

import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList
import com.alife.anotherlife.core.composable.text.text_formation.mask.patterns.BirthdayPattern
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.BaseUnits
import com.alife.anotherlife.core.composable.text.text_formation.mask.units.StaticUnits
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class TestMaskListNotEmptyUnitCount {

    private lateinit var maskList: MaskList

//    @Before
//    fun before() {
//        maskList = MaskList(
//            StaticUnits.Plus(),
//            BaseUnits.EmptyUnit(),
//            StaticUnits.Separator(),
//            BaseUnits.EmptyUnit()
//        )
//    }
//
//    @Test
//    fun `test get not empty units count`() {
//        val testListOffsets = 0
//
//        testListOffsets.forEach { offset ->
//            val actual = maskList.notEmptyUnitCount(offset)
//
//            val expected = 1
//
//            TestCase.assertEquals(actual, expected)
//        }
//    }

    @Test
    fun `test get formatted offset 0 position`() {
        maskList = BirthdayPattern().birthdayTestMask
        // 12.12.2222

        val testListOffsets = 0

        val actual = maskList.getOffsetPosition(testListOffsets)

        val expected = 0

        TestCase.assertEquals(expected, actual)
    }

    @Test
    fun `test get formatted offset last position`() {
        maskList = BirthdayPattern().birthdayTestMask
        // 12.12.2222

        val testListOffsets = 8

        val actual = maskList.getOffsetPosition(testListOffsets)

        val expected = 10

        TestCase.assertEquals(expected, actual)
    }

    @Test
    fun `test get formatted offset 2 position`() {
        maskList = BirthdayPattern().birthdayTestMask
        // 12.12.2222

        val testListOffsets = 2

        val actual = maskList.getOffsetPosition(testListOffsets)

        val expected = 2

        TestCase.assertEquals(expected, actual)
    }

    @Test
    fun `test get formatted offset 3 position`() {
        maskList = BirthdayPattern().birthdayTestMask
        // 12.12.2222

        val testListOffsets = 3

        val actual = maskList.getOffsetPosition(testListOffsets)

        val expected = 4

        TestCase.assertEquals(expected, actual)
    }
}