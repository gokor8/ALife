package com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.navigation.args

import androidx.navigation.NavType
import com.alife.anotherlife.core.navigation.nav_arg.BaseNavigationArg
import com.alife.anotherlife.core.navigation.nav_arg.DefaultNavigationArg
import com.alife.anotherlife.core.navigation.nav_arg_container.ArgsContainer


class UsernameNavArg : DefaultNavigationArg<String?>("userId", NavType.StringType)

class PostProfileArgsContainer: ArgsContainer {

    val username = UsernameNavArg()

    override fun argsList(): List<BaseNavigationArg<*>> = listOf(username)
}