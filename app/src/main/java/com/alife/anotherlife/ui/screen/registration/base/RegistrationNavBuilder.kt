package com.alife.anotherlife.ui.screen.registration.base

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder

class RegistrationNavBuilder : NewDefaultNavBuilder(RegistrationNavRoute()) {

    @Composable
    override fun Content(navBackStackEntry: NavBackStackEntry) {

    }
}