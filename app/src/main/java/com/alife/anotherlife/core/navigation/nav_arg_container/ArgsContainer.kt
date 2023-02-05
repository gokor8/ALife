package com.alife.anotherlife.core.navigation.nav_arg_container

import com.alife.anotherlife.core.navigation.nav_arg.BaseNavigationArg

interface ArgsContainer {

    fun argsList(): List<BaseNavigationArg<*>>
}