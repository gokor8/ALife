package com.alife.anotherlife.ui.screen.login

import androidx.compose.runtime.Composable
import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseLoginAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.model.AuthType
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.anotherlife.ui.screen.login.reducer.LoginReducer
import com.alife.anotherlife.ui.screen.login.state.LoginState
import com.alife.domain.login.LoginAuthType
import com.alife.domain.login.base.BaseLoginAuthTypeUseCase
import com.alife.domain.login.entity.AuthTypeEntity
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class TestLoginReducer {

    private lateinit var uiStore: FakeUIStore<LoginState, Nothing>
    private lateinit var reducer: LoginReducer

    @Before
    fun before() {
        uiStore = FakeUIStore()

        val firstAuthTypeUseCase = FakeLoginAuthTypeUseCase(TestFirstAuthType())
        val secondAuthTypeUseCase = FakeLoginAuthTypeUseCase(TestSecondAuthType())

        reducer = LoginReducerImpl(
            uiStore,
            firstAuthTypeUseCase,
            secondAuthTypeUseCase,
            FakeLoginAuthTypeToUIAuth()
        )
    }

    fun setupReducer(firstAuthType: AuthTypeEntity, secondAuthType: AuthTypeEntity) {
        reducer = LoginReducerImpl(
            uiStore,
            FakeLoginAuthTypeUseCase(firstAuthType),
            FakeLoginAuthTypeUseCase(secondAuthType),
            FakeLoginAuthTypeToUIAuth()
        )
    }

    @Test
    fun `test get list first + second auth types`() {
        setupReducer(TestFirstAuthType(), TestSecondAuthType())

        reducer.onInit()

        val expected = listOf(
            FakeUIAuthModel.FakeFirst(),
            FakeUIAuthModel.FakeSecond()
        )

        assertEquals(uiStore.stateCollector.size, 1)
        assertEquals(uiStore.getState().supportedAuthService, expected)
    }

    @Test
    fun `test get list with empty auth types`() {
        setupReducer(BadAuthType(), BadAuthType())

        reducer.onInit()

        val expected = listOf(UIAuthModel.Empty(), UIAuthModel.Empty())

        assertEquals(uiStore.stateCollector.size, 1)
        assertEquals(uiStore.getState().supportedAuthService, expected)
    }
}


// Test Realization

class BadAuthType : AuthTypeEntity
class TestFirstAuthType : AuthTypeEntity
class TestSecondAuthType : AuthTypeEntity

sealed interface FakeUIAuthModel : UIAuthModel{

    @Composable
    override fun Button(viewModel: LoginViewModel) {}

    class FakeFirst : FakeUIAuthModel {
        override fun equals(other: Any?) = other != null && other is FakeFirst
    }

    class FakeSecond: FakeUIAuthModel {
        override fun equals(other: Any?) = other != null && other is FakeSecond
    }
}


class FakeLoginAuthTypeUseCase(private val authType: AuthTypeEntity) : LoginAuthType {

    override fun getAuthTypes(): List<AuthTypeEntity> = listOf(authType)
}


class FakeLoginAuthTypeToUIAuth : BaseLoginAuthTypeToUIAuth {

    override fun map(inputModel: List<AuthTypeEntity>): List<UIAuthModel> {
        return inputModel.map { authType ->
            when (authType) {
                is TestFirstAuthType -> FakeUIAuthModel.FakeFirst()
                is TestSecondAuthType -> FakeUIAuthModel.FakeSecond()
                else -> UIAuthModel.Empty()
            }
        }
    }
}