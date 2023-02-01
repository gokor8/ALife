package com.alife.anotherlife.core.navigation.argument.model

import androidx.navigation.NavType

abstract class DefaultNavigationArgModel<TYPE>(
    name: String,
    type: NavType<TYPE>
) : NavigationArgModel<TYPE>(separator = "/", name = name, type = type)