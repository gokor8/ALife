package com.alife.anotherlife.ui.example.navigation.user

import com.alife.anotherlife.core.navigation.nav_arg_container.ArgsContainer
import com.alife.anotherlife.core.navigation.nav_arg.BaseNavigationArg
import com.alife.anotherlife.ui.example.navigation.user.args.UserIdNavArg

class UserArgsContainer: ArgsContainer {

    val userIdNavArg = UserIdNavArg()

    override fun argsList(): List<BaseNavigationArg<*>> = listOf(userIdNavArg)
}