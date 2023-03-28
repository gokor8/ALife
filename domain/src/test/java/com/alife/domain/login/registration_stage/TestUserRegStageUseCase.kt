package com.alife.domain.login.registration_stage

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase
import com.alife.domain.registration.usecase.base.entity.ReadBoxRegEntity
import com.alife.domain.registration.usecase.name.addons.NameException
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestUserRegStageUseCase {

    private lateinit var useCase: UserRegStageUseCaseResult

    private fun setupUseCase(vararg useCases: FakeRegStageUseCase) {
        useCase = UserRegStageUseCaseResult(
            ListRegStageUseCase(*useCases),
            Dispatchers.Unconfined
        )
    }


    @Test
    fun `test when all fail`() = runTest {
        val expected = UseCaseResult.Fail(NameException())

        setupUseCase(
            FakeRegStageUseCase(expected),
            FakeRegStageUseCase(UseCaseResult.EmptyFail()),
            FakeRegStageUseCase(UseCaseResult.EmptyFail())
        )

        val actual = useCase.getStage().useCaseResult

        assertTrue(actual is UseCaseResult.Fail)
        assertEquals(expected, actual)
        assertEquals(expected.exception, (actual as UseCaseResult.Fail).exception)
    }

    @Test
    fun `test when first fail`() = runTest {
        val expected = UseCaseResult.Fail(NameException())

        setupUseCase(
            FakeRegStageUseCase(expected),
            FakeRegStageUseCase(UseCaseResult.EmptySuccess()),
            FakeRegStageUseCase(UseCaseResult.EmptySuccess()),
        )

        val actual = useCase.getStage().useCaseResult

        assertTrue(actual is UseCaseResult.Fail)
        assertEquals(expected, actual)
        assertEquals(expected.exception, (actual as UseCaseResult.Fail).exception)
    }

    @Test
    fun `test when last fail`() = runTest {
        val expected = UseCaseResult.Fail(NameException())

        setupUseCase(
            FakeRegStageUseCase(UseCaseResult.EmptySuccess()),
            FakeRegStageUseCase(UseCaseResult.EmptySuccess()),
            FakeRegStageUseCase(expected),
        )

        val actual = useCase.getStage().useCaseResult

        assertTrue(actual is UseCaseResult.Fail)
        assertEquals(expected, actual)
        assertEquals(expected.exception, (actual as UseCaseResult.Fail).exception)
    }

    @Test
    fun `test when all success`() = runTest {
        val expected = UseCaseResult.EmptySuccess()

        setupUseCase(
            FakeRegStageUseCase(UseCaseResult.EmptySuccess()),
            FakeRegStageUseCase(UseCaseResult.EmptySuccess()),
            FakeRegStageUseCase(expected),
        )

        val actual = useCase.getStage().useCaseResult

        assertTrue(actual is UseCaseResult.BaseSuccess)
        assertEquals(expected, actual)
    }

}


// Fake Realization
class FakeBoxRegEntity(
    useCaseResult: UseCaseResult<Nothing>
) : ReadBoxRegEntity<Nothing>(useCaseResult)

class FakeRegStageUseCase(
    private val useCaseResult: UseCaseResult<Nothing>
) : BaseRegStageUseCase.ReadBox<Nothing> {

    override suspend fun readAndBox(): FakeBoxRegEntity {
        return FakeBoxRegEntity(useCaseResult)
    }
}