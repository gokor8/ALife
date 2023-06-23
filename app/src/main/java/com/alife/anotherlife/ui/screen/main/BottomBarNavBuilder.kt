package com.alife.anotherlife.ui.screen.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.core.navigation.routes.NavigationRoute

abstract class BottomBarNavBuilder(
    protected val innerPadding: PaddingValues,
    navController: NavController,
    navigationRoute: NavigationRoute,
) : NewDefaultNavBuilder(navController, navigationRoute)