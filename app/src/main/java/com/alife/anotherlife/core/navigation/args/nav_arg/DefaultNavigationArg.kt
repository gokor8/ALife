package com.alife.anotherlife.core.navigation.args.nav_arg

import androidx.navigation.NavType

abstract class DefaultNavigationArg<TYPE>(
    name: String,
    type: NavType<TYPE>
) : BaseNavigationArg<TYPE>(separator = "/", name = name, type = type)