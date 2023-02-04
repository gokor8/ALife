package com.alife.anotherlife.ui.test_nav.builder

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.alife.anotherlife.core.navigation.nav_builder.ArgsNavigationRouteBuilder
import com.alife.anotherlife.ui.test_nav.TestUserArgsContainerModel
import com.alife.anotherlife.ui.test_nav.TestUserIdNavRoute

class TestUserArgNavBuilder(
    override val content: @Composable (TestUserArgsContainerModel, NavBackStackEntry) -> Unit
) : ArgsNavigationRouteBuilder<TestUserArgsContainerModel>(TestUserIdNavRoute(), TestUserArgsContainerModel())