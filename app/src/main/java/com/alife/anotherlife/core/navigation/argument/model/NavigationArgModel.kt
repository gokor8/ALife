package com.alife.anotherlife.core.navigation.argument.model

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.alife.anotherlife.core.navigation.argument.NavigationArg

sealed class NavigationArgModel<TYPE>(
    val name: String,
    protected val separator: String,
    protected val type: NavType<TYPE>
) : NavigationArg {

    override fun createNavArg() = navArgument(name) { type }
    override fun toString(): String = "$separator{$name}"
}