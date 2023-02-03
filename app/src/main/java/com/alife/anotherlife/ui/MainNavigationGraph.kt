package com.alife.anotherlife.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.core.navigation.nav_factory.base.NavigationFactory
import com.alife.anotherlife.ui.main_nav_models.TestArgsContainerModel
import com.alife.anotherlife.ui.main_nav_models.TestDefaultNavigationFactory
import com.alife.anotherlife.ui.main_nav_models.TestNavFactory
import com.alife.anotherlife.ui.main_nav_models.UserIdNavArgModel

class MainNavigationGraph(private val startNavigationFactory: NavigationFactory) : NavigationGraph {

    @Composable
    override fun SetupNavigation(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = startNavigationFactory.routeTag
        ) {

            TestNavFactory(
                TestArgsContainerModel(UserIdNavArgModel())
            ).navigationRoute(this) { containerModel, navBackStackEntry ->
                navBackStackEntry.arguments?.getString(containerModel.userIdNavArgModel.name)
                // Some Screen
            }

            TestDefaultNavigationFactory().navigationRoute(this) {
                // Some Screen
            }

            // Сделать с дефолтным значением и диплинком

            startNavigationFactory.navigationRoute(
                navGraphBuilder = this,
            ) { backStackEntry ->
                // Может вынести в енам например, чтобы 2 раза не создавать класс

                // А енам прокидывать сюда и в нав арг модел

                // Еще прокидывать defaultValue надо сразу
                backStackEntry.arguments?.getString(UserIdNavArgModel().name)
            }
        }
    }
}