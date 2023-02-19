package com.alife.anotherlife.ui.screen.login

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.login.LoginUseCaseAnnotations
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseLoginAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseUIAuthToColumnUIAuth
import com.alife.anotherlife.ui.screen.login.reducer.BaseLoginReducer
import com.alife.anotherlife.ui.screen.login.reducer.LoginReducer
import com.alife.anotherlife.ui.screen.login.state.LoginEffect
import com.alife.anotherlife.ui.screen.login.state.LoginState
import com.alife.domain.login.base.ListAuthType
import com.alife.domain.login.base.LoginAuthType
import javax.inject.Inject

class LoginReducerImpl @Inject constructor(
    override val uiStore: UIStore<LoginState, LoginEffect>,
    @LoginUseCaseAnnotations.LoginATUseCase
    private val baseLoginTextsUseCase: LoginAuthType,
    @LoginUseCaseAnnotations.MockATUseCase
    private val mockAuthTypeUseCase: ListAuthType,
    private val loginAuthTypeToUIAuth: BaseLoginAuthTypeToUIAuth,
    private val uiAuthToColumnUIAuth: BaseUIAuthToColumnUIAuth
) : BaseVMReducer<LoginState, LoginEffect>(), BaseLoginReducer {

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
        uiStore.trySetEffect(LoginEffect.NavigateRegistration())
    }

    override fun onAuthService() {

    }
}