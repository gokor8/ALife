package com.alife.anotherlife.ui.screen.login.model.buttons

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.login.LoginViewModel

interface UIAuthModel {

    @Composable
    fun Button(viewModel: LoginViewModel, modifier: Modifier)


    class Empty : UIAuthModel {
        @Composable
        override fun Button(viewModel: LoginViewModel, modifier: Modifier) {}
    }
}