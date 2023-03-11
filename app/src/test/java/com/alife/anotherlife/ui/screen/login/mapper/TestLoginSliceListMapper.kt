package com.alife.anotherlife.ui.screen.login.mapper

import com.alife.anotherlife.ui.screen.login.model.FakeAuthTypeEntity
import com.alife.domain.login.content.entity.AuthTypeEntity
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class TestLoginSliceListMapper {

    private val loginSliceListMapper = LoginSliceListMapper()

    @Test
    fun `test slice list with 0 items`() {
        val testList = emptyList<AuthTypeEntity>()

        val actual = loginSliceListMapper.map(testList)

        val expected = emptyList<AuthTypeEntity>()

        assertEquals(actual, expected)
    }

    @Test
    fun `test slice list with 1 items`() {
        val testList = listOf(FakeAuthTypeEntity.FakeFirstAuthType())

        val actual = loginSliceListMapper.map(testList)

        val expected = emptyList<AuthTypeEntity>()

        assertEquals(actual, expected)
    }

    @Test
    fun `test slice list with 2 items`() {
        val testList = listOf(
            FakeAuthTypeEntity.FakeFirstAuthType(),
            FakeAuthTypeEntity.FakeSecondAuthType()
        )

        val actual = loginSliceListMapper.map(testList)

        assertEquals(actual.size, 1)
        assertTrue(actual.first() is FakeAuthTypeEntity.FakeSecondAuthType)
    }
}