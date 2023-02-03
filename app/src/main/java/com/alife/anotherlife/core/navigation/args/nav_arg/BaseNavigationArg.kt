package com.alife.anotherlife.core.navigation.args.nav_arg

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.alife.anotherlife.core.navigation.args.nav_arg.base.NavigationArg

abstract class BaseNavigationArg<TYPE>(
    val name: String,
    protected val separator: String,
    protected val type: NavType<TYPE>
) : NavigationArg {

    override fun createNavArg() = navArgument(name) { type }
    override fun toString(): String = "$separator{$name}"
}
