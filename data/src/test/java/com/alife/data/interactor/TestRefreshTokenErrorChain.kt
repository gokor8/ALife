package com.alife.data.interactor

import com.alife.core.addons.JsonWrapper
import com.alife.data.core.TestModelContainer
import com.alife.data.core.TokenRequestFactory
import com.alife.data.interceptor.model.RefreshTokenErrorChain
import com.alife.data.interceptor.model.TokenErrorChainModel
import com.alife.data.interceptor.model.TokensModel
import com.alife.domain.core.exception_global.RefreshTokenDied
import com.alife.domain.registration.usecase.token.cache.BaseTokensUseCase
import com.alife.domain.registration.usecase.token.cache.TokenStateEntity
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.io.Reader
import java.lang.IllegalStateException

class TestRefreshTokenErrorChain {

    private val testModelContainer = TestModelContainer(AssertModel())

    private val tokenRequestFactory = TokenRequestFactory("http:test.com/")

    private var defaultRequestInterceptor = RefreshTokenErrorChain(
        FakeTokensUseCase(
            TokenStateEntity.Fill("", ""),
            testModelContainer
        ),
        FakeJsonWrapper(testModelContainer),
        tokenRequestFactory
    )

    @Before
    fun before() {
        testModelContainer.setState(AssertModel())
    }

    @Test
    fun `handle with success refresh response`() = runBlocking {
        defaultRequestInterceptor.handle(TokenErrorChainModel("", FakeChainInterceptor()))

        TestCase.assertTrue(testModelContainer.getState().assertFirstTest())
    }

    @Test
    fun `handle with toJson exception`() = runBlocking {
        defaultRequestInterceptor = RefreshTokenErrorChain(
            FakeTokensUseCase(TokenStateEntity.Fill("", ""), testModelContainer),
            FakeJsonWrapper(testModelContainer),
            tokenRequestFactory
        )

        try {
            defaultRequestInterceptor.handle(
                TokenErrorChainModel("", FakeChainInterceptor(responseCode = 404))
            )
        } catch (e: RefreshTokenDied) {
            testModelContainer.setState { copy(wasException = true) }
        }

        TestCase.assertTrue(testModelContainer.getState().assertSecondTest())
    }

    @Test
    fun `handle with json exception response`() = runBlocking {
        defaultRequestInterceptor = RefreshTokenErrorChain(
            FakeTokensUseCase(TokenStateEntity.Fill("", ""), testModelContainer),
            FakeJsonWrapper(testModelContainer, IllegalStateException()),
            tokenRequestFactory
        )

        try {
            defaultRequestInterceptor.handle(
                TokenErrorChainModel("", FakeChainInterceptor())
            )
        } catch (e : IllegalStateException) {
            testModelContainer.setState { copy(wasException = true) }
        }

        TestCase.assertTrue(testModelContainer.getState().assertThirdTest())
    }

    // Test Realization
    data class AssertModel(
        private val toJson: Boolean = false,
        private val fromJson: Boolean = false,
        private val saveTokens: Boolean = false,
        private val deleteTokens: Boolean = false,
        private val wasException: Boolean = false
    ) {
        fun assertFirstTest(): Boolean =
            toJson && fromJson && saveTokens && !deleteTokens && !wasException

        fun assertSecondTest(): Boolean = toJson && deleteTokens && wasException && !fromJson && !saveTokens

        fun assertThirdTest(): Boolean = toJson && wasException && !deleteTokens && !fromJson && !saveTokens
    }

    class FakeJsonWrapper(
        private val containerModel: TestModelContainer<AssertModel>,
        private val exception: Exception? = null
    ) : JsonWrapper {

        override fun toJson(`object`: Any): String {
            containerModel.setState { copy(toJson = true) }
            return exception?.let { throw it } ?: ""
        }

        override fun <T> fromJson(json: Reader?, classOfT: Class<T>): T {
            containerModel.setState { copy(fromJson = true) }
            return exception?.let { throw it } ?: TokensModel("", "") as T
        }

        override fun <T> fromJson(json: String, classOfT: Class<T>): T {
            containerModel.setState { copy(fromJson = true) }
            return exception?.let { throw it } ?: TokensModel("", "") as T
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
            return returnToken
        }

        override suspend fun deleteTokens() {
            testModelContainer.setState { copy(deleteTokens = true) }
        }
    }
}