package com.alife.anotherlife.ui.screen.login

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseLoginAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.reducer.AbstractLoginReducer
import com.alife.anotherlife.ui.screen.login.state.LoginState
import com.alife.domain.login.base.BaseLoginAuthTypeUseCase
import com.alife.domain.login.base.BaseMockAuthTypeUseCase
import javax.inject.Inject

class LoginReducerImpl @Inject constructor(
    override val uiStore: UIStore<LoginState, Nothing>,
    private val baseLoginTextsUseCase: BaseLoginAuthTypeUseCase,
    private val mockAuthTypeUseCase: BaseMockAuthTypeUseCase,
    private val loginAuthTypeToUIAuth: BaseLoginAuthTypeToUIAuth
) : AbstractLoginReducer() {

    override fun onInit() {
        val defaultAuthEntities = baseLoginTextsUseCase.getAuthTypes()
        val mockAuthEntities = mockAuthTypeUseCase.getAuthTypes()

        val uiAuthTypes = loginAuthTypeToUIAuth.map(defaultAuthEntities) +
                loginAuthTypeToUIAuth.map(mockAuthEntities)

        uiStore.setState(
            LoginState(uiAuthTypes)
        )
    }

    override fun onLoginIn() {

    }

    override fun onRegistration() {

    }

    override fun onAuthService() {

    }
}