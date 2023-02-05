package com.alife.anotherlife.core.navigation.nav_arg.base

import androidx.navigation.NamedNavArgument

interface NavigationArg {

    fun createNavArg(): NamedNavArgument
}