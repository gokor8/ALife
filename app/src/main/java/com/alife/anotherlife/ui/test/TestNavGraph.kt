package com.alife.anotherlife.ui.test

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.ui.test.navigation.TestNavBuilder
import com.alife.anotherlife.ui.test.navigation.TestNavRoute
import com.alife.anotherlife.ui.test.screen.TestScreen
import com.alife.anotherlife.ui.test.screen.TestViewModel

class TestNavGraph : NavigationGraph {

    @Composable
    override fun SetupNavigation(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = TestNavRoute().routeTag
        ) {
            TestNavBuilder {
                val viewModel: TestViewModel = viewModel()
                TestScreen().Content(viewModel)
            }.navComposable(this)
        }
    }
}