package com.alife.anotherlife.ui.test_nav

import androidx.navigation.NamedNavArgument
import com.alife.anotherlife.core.navigation.nav_arg_container.ArgsContainer
import com.alife.anotherlife.core.navigation.nav_arg.BaseNavigationArg
import com.alife.anotherlife.core.navigation.routes.NavigationRoute
import com.alife.anotherlife.ui.test_nav.args.UserIdNavArgModel
import com.alife.anotherlife.ui.test_nav.route.TestUserNavRoute

sealed class TestUserArgsContainer: ArgsContainer {

    val userIdNavArgModel = UserIdNavArgModel()

    override fun argsList(): List<BaseNavigationArg<*>> = listOf(userIdNavArgModel)


    class TestUserArgsBuilder : TestUserArgsContainer(), ArgsContainer.Builder {
        override fun navArgList(): List<NamedNavArgument> = argsList().map { it.createNavArg() }
    }

    class TestUserArgsNavigator(
        val userId: String
    ) : TestUserArgsContainer(), ArgsContainer.Navigator {

        override val route = TestUserNavRoute()

        override fun navigationRoute(): String {
            return super.navigationRoute() + userIdNavArgModel.navigationArg(userId)
        }
    }
}