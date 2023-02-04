package com.alife.anotherlife.ui.test_nav

import com.alife.anotherlife.core.navigation.nav_builder.args.ArgsContainerModel
import com.alife.anotherlife.core.navigation.nav_builder.args.nav_arg.BaseNavigationArg

class TestUserArgsContainerModel: ArgsContainerModel {

    val userIdNavArgModel = UserIdNavArgModel()

    override fun navArgList(): List<BaseNavigationArg<*>> = listOf(userIdNavArgModel)
}