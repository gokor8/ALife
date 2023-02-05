package com.alife.anotherlife.ui.test_nav.builder

import androidx.navigation.NavBackStackEntry
import com.alife.anotherlife.core.navigation.nav_builder.ArgsNavigationBuilder
import com.alife.anotherlife.ui.test_nav.TestUserArgsContainer
import com.alife.anotherlife.ui.test_nav.route.TestUserNavRoute

class TestUserArgsNavBuilder(
    override val content: (TestUserArgsContainer.TestUserArgsBuilder, NavBackStackEntry) -> Unit
) : ArgsNavigationBuilder<TestUserArgsContainer.TestUserArgsBuilder>(
    TestUserNavRoute(),
    TestUserArgsContainer.TestUserArgsBuilder()
)