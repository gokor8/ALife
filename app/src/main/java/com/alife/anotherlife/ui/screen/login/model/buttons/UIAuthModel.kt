package com.alife.anotherlife.ui.screen.login.model.buttons

import androidx.compose.runtime.Composable
import com.alife.anotherlife.ui.screen.login.LoginViewModel
import com.alife.anotherlife.ui.screen.login.model.AuthType

interface UIAuthModel {

    @Composable
    fun Button(viewModel: LoginViewModel)


    class Empty : UIAuthModel {
        @Composable
        override fun Button(viewModel: LoginViewModel) {}
    }
}