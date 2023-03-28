package com.alife.anotherlife.ui.example.test

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.ui.example.test.navigation.TestNavBuilder
import com.alife.anotherlife.ui.example.test.navigation.TestNavRoute
import com.alife.anotherlife.ui.example.test.screen.TestScreen
import com.alife.anotherlife.ui.example.test.screen.TestViewModel

class TestNavGraph : NavigationGraph {

    @Composable
    override fun SetupNavigation(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = TestNavRoute().routeTag
        ) {
            TestNavBuilder {
                TestScreen(navHostController).SetupContent()
            }.navComposable(this)
        }
    }
}