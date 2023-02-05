package com.alife.anotherlife.ui.example.navigation.start

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.alife.anotherlife.core.navigation.nav_builder.DefaultNavigationBuilder

class StartNavBuilder(override val content: @Composable (NavBackStackEntry) -> Unit) :
    DefaultNavigationBuilder(StartNavRoute())