package com.alife.anotherlife.ui.test.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.alife.anotherlife.core.navigation.nav_builder.DefaultNavigationBuilder

class TestNavBuilder(
    override val content: @Composable (NavBackStackEntry) -> Unit
) : DefaultNavigationBuilder(TestNavRoute())