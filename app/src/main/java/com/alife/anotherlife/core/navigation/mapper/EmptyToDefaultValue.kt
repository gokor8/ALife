package com.alife.anotherlife.core.navigation.mapper

import com.alife.anotherlife.core.navigation.nav_arg.BaseNavigationArg

class EmptyStringToDefaultValue {

    fun<M : String?> map(navArg: BaseNavigationArg<M>, newValue: M): String {
        return if(newValue.isNullOrEmpty()) "" else navArg.navRoute(newValue)
    }
}