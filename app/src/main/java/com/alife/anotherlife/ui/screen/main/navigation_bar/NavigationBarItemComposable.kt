package com.alife.anotherlife.ui.screen.main.navigation_bar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.navigation.routes.NavigationRoute

interface NavigationBarItemComposable {

    @Composable
    fun Content(
        rowScope: RowScope,
        navRepeat: Sequence<NavDestination>,
        navController: NavController
    )


    abstract class Abstract(
        @DrawableRes private val icon: Int,
        @StringRes private val labelText: Int,
        private val navRoute: NavigationRoute
    ) : NavigationBarItemComposable {

        @Composable
        override fun Content(
            rowScope: RowScope,
            navRepeat: Sequence<NavDestination>,
            navController: NavController
        ) {
            rowScope.NavigationBarItem(
                icon = { IconBase(icon) },
                label = { TextBase(labelText) },
                selected = navRepeat.any { it.route == navRoute.routeTag },
                //colors = colors(),
                onClick = {
                    navController.navigate(navRoute.routeTag) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}