package com.alife.anotherlife.core.navigation.argument

import androidx.navigation.NamedNavArgument

interface NavigationArg {

    fun createNavArg(): NamedNavArgument
}