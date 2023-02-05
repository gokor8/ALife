package com.alife.anotherlife.core.navigation.nav_builder.args.nav_arg

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.alife.anotherlife.core.navigation.nav_builder.args.nav_arg.base.NavigationArg

abstract class BaseNavigationArg<TYPE>(
    val name: String,
    protected val separator: String,
    protected val type: NavType<TYPE>
) : NavigationArg {

    fun navigationArg(arg: TYPE) = "$separator{$arg}"
    override fun createNavArg() = navArgument(name) { type = this@BaseNavigationArg.type }
    override fun toString(): String = "$separator{$name}"
}
