package com.alife.domain.registration.usecase.username

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.entity.ReadCacheInputEntity
import com.alife.domain.registration.usecase.base.entity.SaveCacheInputEntity
import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity
import com.alife.domain.registration.usecase.username.addons.UsernameException
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity
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

        val actual = usernameReadUseCase.readData()

        assertTrue(actual is UseCaseResult.Success)
        assertEquals(expected, (actual as UseCaseResult.Success<UsernameRegEntity>).model.username)
    }

    @Test
    fun `test empty read fail`() = runTest {
        val exception = UsernameException()
        setupUseCase("", exception)

        val actual = usernameReadUseCase.readData()

        assertTrue(actual is UseCaseResult.Fail)
        assertEquals((actual as UseCaseResult.Fail).exception, exception)
    }

    @Test
    fun `test exception read fail`() = runTest {
        val exception = IllegalStateException()
        setupUseCase("test", exception)

        val actual = usernameReadUseCase.readData()

        assertTrue(actual is UseCaseResult.Fail)
        assertEquals((actual as UseCaseResult.Fail).exception, exception)
    }
}

// Fake realization
class FakeRegistrationRepository(
    private val readData: String,
    private val readException: Exception? = null
) : BaseRegistrationRepository {

    override fun saveRegData(regEntity: SaveCacheInputEntity<*>) {

    }

    override fun <M : Any> readRegData(regEntity: ReadCacheInputEntity<M>): M {
        readException?.apply { throw readException }
        readData.takeIf { it.isNotEmpty() } ?: throw UsernameException()
        return readData as M
    }

    override fun sendRegData(regDataEntity: RegDataEntity) {
        TODO("Not yet implemented")
    }
}