package com.alife.anotherlife.ui.example.navigation.user.builder

import androidx.navigation.NavBackStackEntry
import com.alife.anotherlife.core.navigation.nav_builder.DefaultNavigationBuilder
import com.alife.anotherlife.ui.example.navigation.user.UserNavRoute

class UserNavBuilder(
    override val content: (NavBackStackEntry) -> Unit
) : DefaultNavigationBuilder(UserNavRoute())