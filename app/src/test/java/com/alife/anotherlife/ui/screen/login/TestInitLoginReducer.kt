package com.alife.anotherlife.ui.screen.login

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.ui.screen.login.mapper.BoxRegEntityToNavigator
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseLoginAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseUIAuthToColumnUIAuth
import com.alife.anotherlife.ui.screen.login.model.FakeUIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.ColumnContainerUIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.anotherlife.ui.screen.login.reducer.LoginReducer
import com.alife.anotherlife.ui.screen.login.state.LoginEffect
import com.alife.anotherlife.ui.screen.login.state.LoginState
import com.alife.domain.login.content.base.ListAuthType
import com.alife.domain.login.content.base.LoginAuthType
import com.alife.domain.login.content.entity.AuthTypeEntity
import com.alife.domain.login.content.entity.DefaultAuthTypeEntity
import com.alife.domain.login.content.entity.LoginAuthTypeEntity
import com.alife.domain.login.content.entity.MockImageAuthTypeEntity
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class TestInitLoginReducer {

    private lateinit var uiStore: FakeUIStore<LoginState, LoginEffect>
    private lateinit var reducer: LoginReducer

    @Before
    fun before() {
        uiStore = FakeUIStore(LoginState())
    }

    private fun setupReducer(
        firstAuthTypes: List<UIAuthModel>,
        secondAuthTypes: List<UIAuthModel>,
        isLoadImagesEmpty: Boolean = false,
    ) {
        reducer = LoginReducerImplBase(
            uiStore,
            FakeLoginAuthTypeUseCase(),
            FakeMockAuthTypeUseCase(isLoadImagesEmpty),
            FakeLoginAuthTypeToContainerUIAuth(firstAuthTypes),
            FakeUIAuthToColumnUIAuth(secondAuthTypes),
            FakeUserRegStageUseCase(),
            BoxRegEntityToNavigator()
        )
    }

    @Test
    fun `test get list first + second auth types`() {
        setupReducer(
            listOf(FakeUIAuthModel.FakeFirst()),
            listOf(FakeUIAuthModel.FakeSecond())
        )

        reducer.onInit()

        assertEquals(uiStore.stateCollector.size, 2)
        assertEquals(uiStore.getState().supportedAuthService.size, 2)
        assertEquals(uiStore.getState().supportedAuthService.first(), FakeUIAuthModel.FakeFirst())
        assertEquals(
            uiStore.getState().supportedAuthService.last(),
            ColumnContainerUIAuthModel(FakeUIAuthModel.FakeSecond())
        )
    }

    @Test
    fun `test with empty loaded images usecase`() {
        setupReducer(
            listOf(FakeUIAuthModel.FakeFirst()),
            listOf(FakeUIAuthModel.FakeSecond()),
            true
        )

        reducer.onInit()

        assertEquals(uiStore.stateCollector.size, 2)
        assertEquals(uiStore.getState().supportedAuthService.size, 2)
        assertEquals(uiStore.getState().supportedAuthService.first(), FakeUIAuthModel.FakeFirst())
        assertEquals(
            uiStore.getState().supportedAuthService.last(),
            ColumnContainerUIAuthModel(FakeUIAuthModel.FakeSecond())
        )
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

class FakeMockAuthTypeUseCase(private val isEmpty: Boolean) : ListAuthType {
    override fun getAuthTypes(): List<MockImageAuthTypeEntity> = if (isEmpty)
        emptyList()
    else
        listOf(
            MockImageAuthTypeEntity.VKAuthTypeEntity(),
            MockImageAuthTypeEntity.GoogleAuthTypeEntity(),
            MockImageAuthTypeEntity.InstagramAuthTypeEntity()
        )
}