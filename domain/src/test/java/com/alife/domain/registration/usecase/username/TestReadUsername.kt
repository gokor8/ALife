package com.alife.domain.registration.usecase.username

import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.usecase.base.ReadRegInputEntity
import com.alife.domain.registration.usecase.base.SaveRegInputEntity
import com.alife.domain.registration.usecase.username.addons.UsernameException
import com.alife.domain.registration.usecase.username.mapper.ThrowToUsernameRegEntity
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestReadUsername {

    private lateinit var usernameReadUseCase: UsernameReadRegStageUC

    @Before
    fun before() {
        usernameReadUseCase = UsernameReadRegStageUC(
            FakeRegistrationRepository("test"),
            dispatcher = Dispatchers.Unconfined,
            ThrowToUsernameRegEntity()
        )
    }

    private fun setupUseCase(readData: String, exception: Exception? = null) {
        usernameReadUseCase = UsernameReadRegStageUC(
            FakeRegistrationRepository(readData, exception),
            dispatcher = Dispatchers.Unconfined,
            ThrowToUsernameRegEntity()
        )
    }

    @Test
    fun `test not empty read success`() = runTest {
        val expected = "test"

        val actual = usernameReadUseCase.readData().regEntity

        assertTrue(actual is DefaultRegEntity.Success)
        assertEquals(expected, (actual as DefaultRegEntity.Success).result)
    }

    @Test
    fun `test empty read fail`() = runTest {
        setupUseCase("", UsernameException())

        val actual = usernameReadUseCase.readData().regEntity

        assertTrue(actual is DefaultRegEntity.Fail)
        assertTrue((actual as DefaultRegEntity.Fail).throwable is UsernameException)
    }

    @Test
    fun `test exception read fail`() = runTest {
        setupUseCase("test", IllegalStateException())

        val actual = usernameReadUseCase.readData().regEntity

        assertTrue(actual is DefaultRegEntity.Fail)
        assertTrue((actual as DefaultRegEntity.Fail).throwable is IllegalStateException)
    }
}

// Fake realization
class FakeRegistrationRepository(
    private val readData: String,
    private val readException: Exception? = null
) : BaseRegistrationRepository {

    override fun saveRegData(regEntity: SaveRegInputEntity<*>) {

    }

    override fun <M : Any> readRegData(regEntity: ReadRegInputEntity<M>): M {
        readException?.apply { throw readException }
        readData.takeIf { it.isNotEmpty() } ?: throw UsernameException()
        return readData as M
    }
}