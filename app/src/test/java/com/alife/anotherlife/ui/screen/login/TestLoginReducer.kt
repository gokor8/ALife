package com.alife.anotherlife.ui.screen.login

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseLoginAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseUIAuthToColumnUIAuth
import com.alife.anotherlife.ui.screen.login.model.FakeUIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.ColumnContainerUIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.anotherlife.ui.screen.login.reducer.LoginReducer
import com.alife.anotherlife.ui.screen.login.state.LoginState
import com.alife.domain.login.base.ListAuthType
import com.alife.domain.login.base.LoginAuthType
import com.alife.domain.login.entity.AuthTypeEntity
import com.alife.domain.login.entity.DefaultAuthTypeEntity
import com.alife.domain.login.entity.LoginAuthTypeEntity
import com.alife.domain.login.entity.MockImageAuthTypeEntity
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class TestLoginReducer {

    private lateinit var uiStore: FakeUIStore<LoginState, Nothing>
    private lateinit var reducer: LoginReducer

    @Before
    fun before() {
        uiStore = FakeUIStore()
    }

    private fun setupReducer(
        useCaseAuthTypes: List<MockImageAuthTypeEntity>,
        firstAuthTypes: List<UIAuthModel>,
        secondAuthTypes: List<UIAuthModel>
    ) {
        reducer = LoginReducerImpl(
            uiStore,
            FakeLoginAuthTypeUseCase(),
            FakeMockAuthTypeUseCase(useCaseAuthTypes),
            FakeLoginAuthTypeToContainerUIAuth(firstAuthTypes),
            FakeUIAuthToColumnUIAuth(secondAuthTypes)
        )
    }

    @Test
    fun `test get list first + second auth types`() {
        setupReducer(
            listOf(
                MockImageAuthTypeEntity.VKAuthTypeEntity(),
                MockImageAuthTypeEntity.GoogleAuthTypeEntity(),
                MockImageAuthTypeEntity.InstagramAuthTypeEntity()
            ),
            listOf(FakeUIAuthModel.FakeFirst()),
            listOf(FakeUIAuthModel.FakeSecond())
        )

        reducer.onInit()

        assertEquals(uiStore.stateCollector.size, 1)
        assertEquals(uiStore.getState().supportedAuthService.size, 2)
        assertTrue(uiStore.getState().supportedAuthService.first() is FakeUIAuthModel.FakeFirst)
        assertTrue(uiStore.getState().supportedAuthService.last() is ColumnContainerUIAuthModel)
    }

    @Test
    fun `test with empty return usecase`() {
        setupReducer(
            emptyList(),
            listOf(FakeUIAuthModel.FakeFirst()),
            listOf(FakeUIAuthModel.FakeSecond())
        )

        reducer.onInit()

        assertEquals(uiStore.stateCollector.size, 1)
        assertEquals(uiStore.getState().supportedAuthService.size, 2)
        assertTrue(uiStore.getState().supportedAuthService.first() is FakeUIAuthModel.FakeFirst)
        assertTrue(uiStore.getState().supportedAuthService.last() is FakeUIAuthModel.FakeSecond)
    }

    @Test
    fun `test with 1 authstate return from usecase`() {
        setupReducer(
            listOf(MockImageAuthTypeEntity.VKAuthTypeEntity()),
            listOf(FakeUIAuthModel.FakeFirst()),
            listOf(FakeUIAuthModel.FakeSecond())
        )

        reducer.onInit()

        assertEquals(uiStore.stateCollector.size, 1)
        assertEquals(uiStore.getState().supportedAuthService.size, 1)
        assertTrue(uiStore.getState().supportedAuthService.first() is FakeUIAuthModel.FakeFirst)
    }
}



// Test Realization
class FakeLoginAuthTypeToContainerUIAuth(private val authMode: List<UIAuthModel>) :
    BaseLoginAuthTypeToUIAuth {
    override fun map(
        inputModel: LoginAuthTypeEntity,
        thirdAuthType: MockImageAuthTypeEntity?
    ): List<UIAuthModel> = authMode
}

class FakeUIAuthToColumnUIAuth(private val uiAuthModels: List<UIAuthModel>) :
    BaseUIAuthToColumnUIAuth {
    override fun map(inputModel: List<AuthTypeEntity>) = uiAuthModels.map {
        ColumnContainerUIAuthModel(it)
    }
}

class FakeLoginAuthTypeUseCase : LoginAuthType {

    override fun getLoginAuthTypes() = LoginAuthTypeEntity(
        DefaultAuthTypeEntity.HorizontalLogoEntity(),
        DefaultAuthTypeEntity.RegistrationEntity(),
        DefaultAuthTypeEntity.LoginInEntity(),
    )
}

class FakeMockAuthTypeUseCase(private val authTypes: List<MockImageAuthTypeEntity>) : ListAuthType {
    override fun getAuthTypes(): List<MockImageAuthTypeEntity> = authTypes
}