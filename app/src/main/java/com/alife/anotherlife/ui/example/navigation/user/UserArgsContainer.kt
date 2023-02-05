package com.alife.anotherlife.ui.example.navigation.user

import com.alife.anotherlife.core.navigation.nav_arg_container.ArgsContainer
import com.alife.anotherlife.core.navigation.nav_arg.BaseNavigationArg
import com.alife.anotherlife.ui.example.navigation.user.args.UserIdNavArg
import com.alife.anotherlife.ui.example.navigation.user.args.UserNameOptionalArg

class UserArgsContainer: ArgsContainer {

    val userIdNavArg = UserIdNavArg()
    val optionalUserName = UserNameOptionalArg("optional")

    override fun argsList(): List<BaseNavigationArg<*>> = listOf(userIdNavArg, optionalUserName)
}