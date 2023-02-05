package com.alife.anotherlife.ui.test_nav.builder

import androidx.navigation.NavBackStackEntry
import com.alife.anotherlife.core.navigation.nav_builder.DefaultNavigationRoute
import com.alife.anotherlife.ui.test_nav.TestUserNavRoute

class TestUserNavBuilder(
    override val content: (NavBackStackEntry) -> Unit
) : DefaultNavigationRoute(TestUserNavRoute())