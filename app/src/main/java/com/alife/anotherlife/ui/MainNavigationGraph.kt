package com.alife.anotherlife.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.core.navigation.NavigationModel
import com.alife.anotherlife.ui.main_nav_models.UserIdNavArgModel

class MainNavigationGraph(private val startNavigationModel: NavigationModel) : NavigationGraph {

    @Composable
    override fun SetupNavigation(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = startNavigationModel.routeTag
        ) {
            startNavigationModel.navigationRoute(
                navGraphBuilder = this,
                listOf(UserIdNavArgModel())
            ) { backStackEntry ->
                // Может вынести в енам например, чтобы 2 раза не создавать класс

                // А енам прокидывать сюда и в нав арг модел

                // Еще прокидывать defaultValue надо сразу
                backStackEntry.arguments?.getString(UserIdNavArgModel().name)
            }
        }
    }
}