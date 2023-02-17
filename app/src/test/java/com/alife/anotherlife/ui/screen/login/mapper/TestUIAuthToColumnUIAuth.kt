package com.alife.anotherlife.ui.screen.login.mapper

import com.alife.anotherlife.ui.screen.login.mapper.container.UIAuthToColumnContainerUIAuth
import com.alife.anotherlife.ui.screen.login.model.FakeListAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.model.FakeUIAuthModel
import com.alife.anotherlife.ui.screen.login.model.FakeAuthTypeEntity
import com.alife.anotherlife.ui.screen.login.model.buttons.ColumnContainerUIAuthModel
import com.alife.core.mapper.ListMapper
import com.alife.domain.login.entity.AuthTypeEntity
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TestUIAuthToColumnUIAuth {

    private val uiAuthToColumnContainerUIAuth = UIAuthToColumnContainerUIAuth(
        FakeListAuthTypeToUIAuth(),
        FakeListSlicer()
    )


    @Test
    fun `test success give 0 uiAuthType`() {
        val testUIAuthList = emptyList<AuthTypeEntity>()

        val actual = uiAuthToColumnContainerUIAuth.map(testUIAuthList)

        assertEquals(actual.size, 0)
    }

    @Test
    fun `test success give 1 uiAuthType`() {
        val testUIAuthList = listOf(
            FakeAuthTypeEntity.FakeFirstAuthType()
        )

        val actual = uiAuthToColumnContainerUIAuth.map(testUIAuthList)

        val expected = ColumnContainerUIAuthModel(
            FakeUIAuthModel.FakeFirst()
        )

        assertEquals(actual.size, 1)
        assertEquals(actual.first(), expected)
    }

    @Test
    fun `test success give 2 uiAuthType`() {
        val testUIAuthList = listOf(
            FakeAuthTypeEntity.FakeFirstAuthType(),
            FakeAuthTypeEntity.FakeSecondAuthType(),
        )

        val actual = uiAuthToColumnContainerUIAuth.map(testUIAuthList)

        val expected = ColumnContainerUIAuthModel(
            FakeUIAuthModel.FakeFirst(),
            FakeUIAuthModel.FakeSecond()
        )

        assertEquals(actual.size, 1)
        assertEquals(actual.first(), expected)
    }

    @Test
    fun `test success give 3 uiAuthType`() {
        val testUIAuthList = listOf(
            FakeAuthTypeEntity.FakeFirstAuthType(),
            FakeAuthTypeEntity.FakeSecondAuthType(),
            FakeAuthTypeEntity.FakeFirstAuthType(),
        )

        val actual = uiAuthToColumnContainerUIAuth.map(testUIAuthList)

        val expected = listOf(
            ColumnContainerUIAuthModel(
                FakeUIAuthModel.FakeFirst(),
                FakeUIAuthModel.FakeSecond(),
            ),
            ColumnContainerUIAuthModel(FakeUIAuthModel.FakeFirst())
        )

        assertEquals(actual.size, 2)
        actual.forEachIndexed { index, uiAuthModel ->
            assertEquals(uiAuthModel, expected[index])
        }
    }
}


// Fake
class FakeListSlicer : ListMapper<AuthTypeEntity> {
    override fun map(inputModel: List<AuthTypeEntity>): List<AuthTypeEntity> = inputModel
}