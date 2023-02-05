package com.alife.anotherlife.ui.test_nav

import com.alife.anotherlife.core.navigation.nav_arg_container.ArgsContainer
import com.alife.anotherlife.core.navigation.nav_navigator.ArgsNavigator
import com.alife.anotherlife.ui.test_nav.route.TestUserNavRoute

class TestUserArgsNavigator(override val containerModel: ArgsContainer.Navigator) :
    ArgsContainer.Navigator(TestUserNavRoute())