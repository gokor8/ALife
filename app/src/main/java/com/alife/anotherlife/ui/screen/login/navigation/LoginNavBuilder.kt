package com.alife.anotherlife.ui.screen.login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.alife.anotherlife.core.navigation.nav_builder.DefaultNavigationBuilder

class LoginNavBuilder(override val content: @Composable (NavBackStackEntry) -> Unit) :
    DefaultNavigationBuilder(LoginNavRoute())