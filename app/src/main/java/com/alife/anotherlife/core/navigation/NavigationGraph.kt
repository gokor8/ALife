package com.alife.anotherlife.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

interface NavigationGraph {

    @Composable
    fun SetupNavigation(navHostController: NavHostController)
}