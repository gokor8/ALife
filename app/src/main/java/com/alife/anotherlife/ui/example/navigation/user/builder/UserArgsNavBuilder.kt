package com.alife.anotherlife.ui.example.navigation.user.builder

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.alife.anotherlife.core.navigation.nav_builder.ArgsNavigationBuilder
import com.alife.anotherlife.ui.example.navigation.user.UserArgsContainer
import com.alife.anotherlife.ui.example.navigation.user.UserNavRoute

class UserArgsNavBuilder(
    override val content: @Composable (UserArgsContainer, NavBackStackEntry) -> Unit
) : ArgsNavigationBuilder<UserArgsContainer>(UserNavRoute(), UserArgsContainer())