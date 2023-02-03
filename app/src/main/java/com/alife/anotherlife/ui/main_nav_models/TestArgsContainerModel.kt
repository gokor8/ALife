package com.alife.anotherlife.ui.main_nav_models

import com.alife.anotherlife.core.navigation.args.ArgsContainerModel
import com.alife.anotherlife.core.navigation.args.nav_arg.BaseNavigationArg

class TestArgsContainerModel(
    val userIdNavArgModel: UserIdNavArgModel
) : ArgsContainerModel {

    override fun navArgList(): List<BaseNavigationArg<*>> = listOf(userIdNavArgModel)
}