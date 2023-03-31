package com.alife.anotherlife.ui.screen.main.create_alife.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeScreen

class CreateAlifeNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, CreateAlifeNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = CreateAlifeScreen()
}