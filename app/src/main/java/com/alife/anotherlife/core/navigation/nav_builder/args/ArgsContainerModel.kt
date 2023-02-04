package com.alife.anotherlife.core.navigation.nav_builder.args

import com.alife.anotherlife.core.navigation.nav_builder.args.nav_arg.BaseNavigationArg

interface ArgsContainerModel {
    fun navArgList(): List<BaseNavigationArg<*>>
}