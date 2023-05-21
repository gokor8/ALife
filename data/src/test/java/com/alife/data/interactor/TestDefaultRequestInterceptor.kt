package com.alife.data.interactor

import com.alife.data.core.TestModelContainer
import com.alife.data.interceptor.DefaultRequestInterceptor
import com.alife.domain.core.exception_global.GlobalException
import com.alife.domain.core.exception_global.GlobalExceptionHandler
import com.alife.domain.registration.usecase.token.BaseTokensUseCase
import com.alife.domain.registration.usecase.token.TokenStateEntity
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class TestDefaultRequestInterceptor {

    private val testModelContainer = TestModelContainer(AssertModel())

    private var defaultRequestInterceptor = DefaultRequestInterceptor(
        FakeGlobalExceptionHandler(testModelContainer),
        FakeTokensUseCase(
            TokenStateEntity.Fill("", ""),
            testModelContainer
        )
    )

    fun createRequestInterceptor(tokenStateEntity: TokenStateEntity) {
        defaultRequestInterceptor = DefaultRequestInterceptor(
            FakeGlobalExceptionHandler(testModelContainer),
            FakeTokensUseCase(tokenStateEntity, testModelContainer)
        )
    }

    @Before
    fun before() {
        testModelContainer.setState(AssertModel())
        createRequestInterceptor(TokenStateEntity.Fill("", ""))
    }

    @Test
    fun `intercept with TokenStateEntity Fill`() {
        val chain = FakeChainInterceptor()

        defaultRequestInterceptor.intercept(chain)

        assertTrue(testModelContainer.getState().assertFirstTest())
    }

    @Test
    fun `intercept with TokenStateEntity Empty`() {
        createRequestInterceptor(TokenStateEntity.Empty())
        val chain = FakeChainInterceptor()

        defaultRequestInterceptor.intercept(chain)

        assertTrue(testModelContainer.getState().assertSecondTest())
    }

    @Test
    fun `intercept Fill with Exception`() {
        val chain = FakeChainInterceptor()

        defaultRequestInterceptor.intercept(chain)

        assertTrue(testModelContainer.getState().assertThirdTest())
    }


    // Test Realization
    data class AssertModel(
        private val saveTokens: Boolean = false,
        private val getTokens: Boolean = false,
        private val deleteTokens: Boolean = false,
        private val exceptionHandle: Boolean = false,
    ) {

        fun assertFirstTest() = getTokens
        fun assertSecondTest() = !getTokens
        fun assertThirdTest() = exceptionHandle && !saveTokens && !getTokens && !deleteTokens
    }

    class FakeGlobalExceptionHandler(
        private val testModelContainer: TestModelContainer<AssertModel>
    ) : GlobalExceptionHandler {

        override fun handle(exception: GlobalException) {
            testModelContainer.setState { copy(exceptionHandle = true) }
        }
    }

    class FakeTokensUseCase(
        private val returnToken: TokenStateEntity,
        private val testModelContainer: TestModelContainer<AssertModel>
    ) : BaseTokensUseCase {

        override suspend fun saveTokens(authorizationToken: String, refreshToken: String) {
            testModelContainer.setState { copy(saveTokens = true) }
        }

        override suspend fun getTokens(): TokenStateEntity {
            testModelContainer.setState { copy(getTokens = true) }
            return returnToken
        }

        override suspend fun deleteTokens() {
            testModelContainer.setState { copy(deleteTokens = true) }
        }
    }
}