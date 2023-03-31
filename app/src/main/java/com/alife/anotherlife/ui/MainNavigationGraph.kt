package com.alife.anotherlife.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.ui.screen.login.navigation.LoginNavBuilder
import com.alife.anotherlife.ui.screen.login.navigation.LoginNavRoute
import com.alife.anotherlife.ui.screen.main.create_alife.navigation.CreateAlifeNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation.MainScreenNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.navigation.HomeNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.friends.navigation.FriendsNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world.navigation.WorldNavBuilder
import com.alife.anotherlife.ui.screen.registration.birthday.navigation.RegBirthdayNavBuilder
import com.alife.anotherlife.ui.screen.registration.email.navigation.RegEmailNavBuilder
import com.alife.anotherlife.ui.screen.registration.email_code.navigation.EmailCodeNavBuilder
import com.alife.anotherlife.ui.screen.registration.name.navigation.RegNameNavBuilder
import com.alife.anotherlife.ui.screen.registration.tutorial.navigation.TutorialNavBuilder
import com.alife.anotherlife.ui.screen.registration.username.navigation.UsernameRegNavBuilder
import javax.inject.Inject

class MainNavigationGraph @Inject constructor(): NavigationGraph {

    @Composable
    override fun SetupNavigation(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = LoginNavRoute().routeTag
        ) {
            listOf(
                LoginNavBuilder(navHostController),
                RegNameNavBuilder(navHostController),
                UsernameRegNavBuilder(navHostController),
                RegBirthdayNavBuilder(navHostController),
                RegEmailNavBuilder(navHostController),
                EmailCodeNavBuilder(navHostController),
                TutorialNavBuilder(navHostController),
                MainScreenNavBuilder(navHostController),
                HomeNavBuilder(navHostController),
                FriendsNavBuilder(navHostController),
                WorldNavBuilder(navHostController),
                CreateAlifeNavBuilder(navHostController)
            ).forEach { it.navComposable(this) }
        }
    }
}