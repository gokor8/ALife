package com.alife.anotherlife.ui.test_nav.builder

import androidx.navigation.NavBackStackEntry
import com.alife.anotherlife.core.navigation.nav_builder.DefaultNavigationBuilder
import com.alife.anotherlife.ui.test_nav.route.TestUserNavRoute

class TestUserNavBuilder(
    override val content: (NavBackStackEntry) -> Unit
) : DefaultNavigationBuilder(TestUserNavRoute())