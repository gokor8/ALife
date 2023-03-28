package com.alife.anotherlife.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.core.navigation.routes.NavigationRoute
import com.alife.anotherlife.ui.screen.login.navigation.LoginNavBuilder
import com.alife.anotherlife.ui.screen.login.navigation.LoginNavRoute
import com.alife.anotherlife.ui.screen.main.main_screen.navigation.MainScreenNavBuilder
import com.alife.anotherlife.ui.screen.registration.birthday.navigation.RegBirthdayNavBuilder
import com.alife.anotherlife.ui.screen.registration.birthday.navigation.RegBirthdayNavRoute
import com.alife.anotherlife.ui.screen.registration.email.navigation.RegEmailNavBuilder
import com.alife.anotherlife.ui.screen.registration.email.navigation.RegEmailNavRoute
import com.alife.anotherlife.ui.screen.registration.email_code.navigation.EmailCodeNavBuilder
import com.alife.anotherlife.ui.screen.registration.name.navigation.RegNameNavBuilder
import com.alife.anotherlife.ui.screen.registration.tutorial.TutorialScreenPreview
import com.alife.anotherlife.ui.screen.registration.tutorial.navigation.TutorialNavBuilder
import com.alife.anotherlife.ui.screen.registration.username.navigation.UsernameRegNavBuilder
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
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
                MainScreenNavBuilder(navHostController)
            ).forEach { it.navComposable(this) }
        }
    }
}