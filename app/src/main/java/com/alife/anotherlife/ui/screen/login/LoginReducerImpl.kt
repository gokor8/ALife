package com.alife.anotherlife.ui.screen.login

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.login.LoginUseCaseAnnotations
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseListAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseLoginAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseUIAuthToColumnUIAuth
import com.alife.anotherlife.ui.screen.login.reducer.AbstractLoginReducer
import com.alife.anotherlife.ui.screen.login.reducer.LoginReducer
import com.alife.anotherlife.ui.screen.login.state.LoginState
import com.alife.domain.login.base.ListAuthType
import com.alife.domain.login.base.LoginAuthType
import javax.inject.Inject

class LoginReducerImpl @Inject constructor(
    override val uiStore: UIStore<LoginState, Nothing>,
    @LoginUseCaseAnnotations.LoginATUseCase
    private val baseLoginTextsUseCase: LoginAuthType,
    @LoginUseCaseAnnotations.MockATUseCase
    private val mockAuthTypeUseCase: ListAuthType,
    private val loginAuthTypeToUIAuth: BaseLoginAuthTypeToUIAuth,
    private val uiAuthToColumnUIAuth: BaseUIAuthToColumnUIAuth
) : AbstractLoginReducer(), LoginReducer {

    override fun onInit() {
        val defaultAuthEntities = baseLoginTextsUseCase.getLoginAuthTypes()
        val mockAuthEntities = mockAuthTypeUseCase.getAuthTypes()

        val uiAuthTypes = loginAuthTypeToUIAuth.map(
            defaultAuthEntities,
            mockAuthEntities.firstOrNull()
        ) + uiAuthToColumnUIAuth.map(mockAuthEntities)

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