package com.alife.domain.login.registration_stage

import com.alife.domain.registration.core.entity.BoxRegEntity
import com.alife.domain.registration.core.entity.RegEntity
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestUserRegStageUseCase {

    private lateinit var useCase: UserRegStageUseCase

    private fun setupUseCase(vararg useCases: FakeRegStageUseCase) {
        useCase = UserRegStageUseCase(
            useCases.toList(),
            Dispatchers.Unconfined,
            ThrowToRegStageEntity()
        )
    }


    @Test
    fun `test when all fail`() = runTest {
        val expected = FakeFail()

        setupUseCase(
            FakeRegStageUseCase(expected),
            FakeRegStageUseCase(FakeFail()),
            FakeRegStageUseCase(FakeFail()),
        )

        val actual = useCase.getStage().regEntity

        assertEquals(expected, actual)
    }

    @Test
    fun `test when first fail`() = runTest {
        val expected = FakeFail()

        setupUseCase(
            FakeRegStageUseCase(expected),
            FakeRegStageUseCase(FakeSuccess()),
            FakeRegStageUseCase(FakeSuccess()),
        )

        val actual = useCase.getStage().regEntity

        assertEquals(expected, actual)
    }

    @Test
    fun `test when last fail`() = runTest {
        val expected = FakeFail()

        setupUseCase(
            FakeRegStageUseCase(FakeSuccess()),
            FakeRegStageUseCase(FakeSuccess()),
            FakeRegStageUseCase(expected),
        )

        val actual = useCase.getStage().regEntity

        assertEquals(expected, actual)
    }

    @Test
    fun `test when all success`() = runTest {
        val expected = FakeSuccess()

        setupUseCase(
            FakeRegStageUseCase(FakeSuccess()),
            FakeRegStageUseCase(FakeSuccess()),
            FakeRegStageUseCase(expected),
        )

        val actual = useCase.getStage().regEntity

        assertEquals(expected, actual)
    }

}


// Fake Realization
class FakeBoxRegEntity(regEntity: RegEntity) : BoxRegEntity(regEntity)

class FakeFail : RegEntity.Fail
class FakeSuccess : RegEntity.Success

class FakeRegStageUseCase(
    private val regEntity: RegEntity
) : BaseRegStageUseCase.Read<FakeBoxRegEntity> {

    override suspend fun readData() = FakeBoxRegEntity(regEntity)
}