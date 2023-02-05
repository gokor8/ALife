package com.alife.anotherlife.ui.test_nav

import com.alife.anotherlife.core.navigation.nav_navigator.ArgsNavigator

class TestUserArgsNavigatorModel(
    val userId: String
) : ArgsNavigator(TestUserNavRoute()) {

    override val containerModel = TestUserArgsContainerModel()

    override fun toString(): String = containerModel.run {
        return super.toString() + userIdNavArgModel.navigationArg(userId)
    }
}