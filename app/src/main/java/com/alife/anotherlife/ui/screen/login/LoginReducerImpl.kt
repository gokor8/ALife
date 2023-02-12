package com.alife.anotherlife.ui.screen.login

import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.login.model.buttons.picture.PictureUIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.text.LoginTextUIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.text.StaticTextUIAuthModel
import com.alife.anotherlife.ui.screen.login.reducer.AbstractLoginReducer
import com.alife.anotherlife.ui.screen.login.state.LoginState
import javax.inject.Inject

class LoginReducerImpl @Inject constructor(
    override val uiStore: UIStore<LoginState, Nothing>,
) : AbstractLoginReducer() {

    override fun onInit() {
        uiStore.setState(
            LoginState(
                listOf(
                    StaticTextUIAuthModel.Logo(),
                    StaticTextUIAuthModel.Hint(),
                    LoginTextUIAuthModel.LoginIn(),
                    LoginTextUIAuthModel.Registration(),
                    PictureUIAuthModel.ResImageUIAuthModel(R.drawable.ic_instagram),
                    PictureUIAuthModel.ResImageUIAuthModel(R.drawable.ic_vk),
                    PictureUIAuthModel.ResImageUIAuthModel(R.drawable.ic_google),
                )
            )
        )
    }

    override fun onLoginIn() {

    }

    override fun onRegistration() {

    }

    override fun onAuthService() {

    }
}