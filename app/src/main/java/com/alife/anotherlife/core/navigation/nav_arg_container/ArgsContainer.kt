package com.alife.anotherlife.core.navigation.nav_arg_container

import androidx.annotation.CallSuper
import androidx.navigation.NamedNavArgument
import com.alife.anotherlife.core.navigation.nav_arg.BaseNavigationArg
import com.alife.anotherlife.core.navigation.routes.NavigationRoute

interface ArgsContainer {

    fun navigationRoute(): String

    fun argsList(): List<BaseNavigationArg<*>>


    interface Builder : ArgsContainer {

        fun navArgList(): List<NamedNavArgument> = argsList().map { it.createNavArg() }

        override fun navigationRoute(): String = argsList().joinToString("") { it.toString() }
    }

    interface Navigator : ArgsContainer {

        val route: NavigationRoute

        @CallSuper
        override fun navigationRoute(): String = route.routeTag
    }
}