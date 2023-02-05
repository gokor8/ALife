package com.alife.anotherlife.ui.example.navigation.user.navigator

import com.alife.anotherlife.core.navigation.nav_navigator.ArgsNavigator
import com.alife.anotherlife.ui.example.navigation.user.UserArgsContainer
import com.alife.anotherlife.ui.example.navigation.user.UserNavRoute

class UserArgsNavigator(
    val userId: String,
    val userName: String = ""
    ) : ArgsNavigator(UserNavRoute()) {

    override val argsContainer = UserArgsContainer()

    override fun toString(): String {
        return super.toString() + argsContainer.userIdNavArg.navRoute(userId) +
                nullToEmpty.map(argsContainer.optionalUserName, userName)
    }
}