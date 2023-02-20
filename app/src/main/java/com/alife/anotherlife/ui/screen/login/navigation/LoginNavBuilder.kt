package com.alife.anotherlife.ui.screen.login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.alife.anotherlife.core.navigation.nav_builder.DefaultNavigationBuilder
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.login.LoginScreen

class LoginNavBuilder : NewDefaultNavBuilder(LoginNavRoute()) {

    @Composable
    override fun Content(navBackStackEntry: NavBackStackEntry) {
        LoginScreen().SetupContent()
    }
}