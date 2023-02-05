package com.alife.anotherlife.core.navigation.nav_arg

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

abstract class OptionalNavigationArg<TYPE>(
    name: String,
    type: NavType<TYPE>,
    private val defaultValue: TYPE?
) : BaseNavigationArg<TYPE>(separator = "?$name=", name = name, type = type) {

    override fun createNavArg(): NamedNavArgument = navArgument(name) {
        defaultValue = this@OptionalNavigationArg.defaultValue
        nullable = this@OptionalNavigationArg.defaultValue == null
        type = this@OptionalNavigationArg.type
    }
}