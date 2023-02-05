package com.alife.anotherlife.ui.example.navigation.user.args

import androidx.navigation.NavType
import com.alife.anotherlife.core.navigation.nav_arg.OptionalNavigationArg

class UserNameOptionalArg(defaultValue: String) :
    OptionalNavigationArg<String?>("userName", NavType.StringType, defaultValue)