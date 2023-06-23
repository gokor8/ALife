package com.alife.anotherlife.ui.screen.main.post_detail.navigation.args

import androidx.navigation.NavType
import com.alife.anotherlife.core.navigation.nav_arg.BaseNavigationArg
import com.alife.anotherlife.core.navigation.nav_arg.DefaultNavigationArg
import com.alife.anotherlife.core.navigation.nav_arg_container.ArgsContainer

class UsernameNavArg : DefaultNavigationArg<String?>("username", NavType.StringType)

class PostDetailArgsContainer : ArgsContainer {

    val username = UsernameNavArg()

    override fun argsList(): List<BaseNavigationArg<*>> = listOf(username)
}
