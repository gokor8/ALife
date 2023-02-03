package com.alife.anotherlife.core.navigation.args

import com.alife.anotherlife.core.navigation.args.nav_arg.BaseNavigationArg

interface ArgsContainerModel {
    fun navArgList(): List<BaseNavigationArg<*>>
}