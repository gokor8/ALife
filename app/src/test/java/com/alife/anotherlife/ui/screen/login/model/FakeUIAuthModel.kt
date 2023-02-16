package com.alife.anotherlife.ui.screen.login.model

import androidx.compose.runtime.Composable
import com.alife.anotherlife.ui.screen.login.LoginViewModel
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel

sealed interface FakeUIAuthModel : UIAuthModel {

    @Composable
    override fun Button(viewModel: LoginViewModel) {}


    class FakeFirst : FakeUIAuthModel {
        override fun equals(other: Any?) = other != null && other is FakeFirst
    }

    class FakeSecond : FakeUIAuthModel {
        override fun equals(other: Any?) = other != null && other is FakeSecond
    }
}