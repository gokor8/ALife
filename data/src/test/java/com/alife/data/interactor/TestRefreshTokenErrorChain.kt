package com.alife.data.interactor

import com.alife.core.addons.JsonWrapper
import com.alife.data.core.TestModelContainer
import com.alife.data.interceptor.model.RefreshTokenErrorChain
import com.alife.data.interceptor.model.TokenErrorChainModel
import com.alife.data.interceptor.model.TokensModel
import com.alife.domain.registration.usecase.token.BaseTokensUseCase
import com.alife.domain.registration.usecase.token.TokenStateEntity
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.io.Reader
import java.lang.Exception
import java.lang.IllegalStateException

class TestRefreshTokenErrorChain {

    private val testModelContainer = TestModelContainer(AssertModel())

    private var defaultRequestInterceptor = RefreshTokenErrorChain(
        FakeTokensUseCase(
            TokenStateEntity.Fill("", ""),
            testModelContainer
        ),
        FakeJsonWrapper(testModelContainer)
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

    @Test(expected = IllegalStateException::class)
    fun `handle with not success refresh response`() = runBlocking {
        defaultRequestInterceptor = RefreshTokenErrorChain(
            FakeTokensUseCase(TokenStateEntity.Fill("", ""), testModelContainer),
            FakeJsonWrapper(testModelContainer, IllegalStateException())
        )

        defaultRequestInterceptor.handle(TokenErrorChainModel("", FakeChainInterceptor()))

        TestCase.assertTrue(testModelContainer.getState().assertSecondTest())
    }

    // Test Realization
    data class AssertModel(
        private val toJson: Boolean = false,
        private val fromJson: Boolean = false,
        private val saveTokens: Boolean = false,
        private val deleteTokens: Boolean = false,
        val exceptionWasHandled: Boolean = false
    ) {
        fun assertFirstTest(): Boolean = toJson && !fromJson && !saveTokens && deleteTokens && exceptionWasHandled
        fun assertSecondTest(): Boolean = toJson && fromJson && saveTokens && !exceptionWasHandled
    }

    class FakeJsonWrapper(
        private val containerModel: TestModelContainer<AssertModel>,
        private val exception: Exception? = null
    ) : JsonWrapper {

        override fun toJson(`object`: Any): String {
            containerModel.setState { copy(toJson = false) }
            return ""
        }

        override fun <T> fromJson(json: Reader?, classOfT: Class<T>): T {
            containerModel.setState { copy(fromJson = false) }
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