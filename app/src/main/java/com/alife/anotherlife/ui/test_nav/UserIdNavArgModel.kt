package com.alife.anotherlife.ui.test_nav

import androidx.navigation.NavType
import com.alife.anotherlife.core.navigation.nav_builder.args.nav_arg.DefaultNavigationArg

class UserIdNavArgModel : DefaultNavigationArg<String?>("userId", NavType.StringType)