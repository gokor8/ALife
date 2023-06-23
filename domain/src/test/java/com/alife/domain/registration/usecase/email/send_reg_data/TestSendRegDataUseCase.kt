package com.alife.domain.registration.usecase.email.send_reg_data

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.entity.ReadCacheInputEntity
import com.alife.domain.registration.usecase.base.entity.SaveCacheInputEntity
import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity
import com.alife.domain.registration.usecase.name.addons.NameException
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestSendRegDataUseCase {

    private lateinit var useCase: SendRegDataUseCase

    private fun setupUseCase(
        useCaseException: Exception? = null,
        repositoryException: Exception? = null
    ) {
        useCase = SendRegDataUseCase(
            Dispatchers.Unconfined,
            ThrowToRegData(),
            FakeRegDataFacadeUseCase(useCaseException),
            FakeRegistrationRepository(repositoryException)
        )
    }

    @Test
    fun `test success sendRegData`() = runTest {
        setupUseCase()

        val actual = useCase.sendRegData()

        val expected = UseCaseResult.Success(Unit)

        assertTrue(actual is UseCaseResult.Success)
    }

    @Test
    fun `test fail sendRegData useCase exception`() = runTest {
        val exception = NameException()
        setupUseCase(useCaseException = exception)

        val actual = useCase.sendRegData()

        val expected = UseCaseResult.Fail(exception)

        assertTrue(actual is UseCaseResult.Fail)
        assertEquals(expected.exception, (actual as UseCaseResult.Fail).exception)
    }

    @Test
    fun `test fail sendRegData repository exception`() = runTest {
        val exception = IllegalStateException()
        setupUseCase(repositoryException = exception)

        val actual = useCase.sendRegData()

        val expected = UseCaseResult.Fail(exception)

        assertTrue(actual is UseCaseResult.Fail)
        assertEquals(expected.exception, (actual as UseCaseResult.Fail).exception)
    }
}

// Test Realization
class FakeRegDataFacadeUseCase(
    private val exception: Exception? = null
) : BaseRegDataFacadeUseCase {

    override suspend fun fillRegData(): RegDataEntity {
        exception?.run { throw exception }
        return RegDataEntity("name", "username", "birthday", "email")
    }
}

class FakeRegistrationRepository(
    private val exception: Exception? = null
) : BaseRegistrationRepository {

    override fun saveRegData(regEntity: SaveCacheInputEntity<*>) {
        TODO("Not yet implemented")
    }

    override fun <M : Any> readRegData(regEntity: ReadCacheInputEntity<M>): M {
        TODO("Not yet implemented")
    }

    override fun sendRegData(regDataEntity: RegDataEntity) {
        exception?.run { throw exception }
    }
}

