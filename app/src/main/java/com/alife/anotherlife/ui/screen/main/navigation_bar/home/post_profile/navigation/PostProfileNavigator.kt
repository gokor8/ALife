package com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.navigation

import com.alife.anotherlife.core.navigation.nav_navigator.ArgsNavigator
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.navigation.args.PostProfileArgsContainer

class PostProfileNavigator(
    private val username: String
): ArgsNavigator(PostProfileNavRoute()) {

    override val argsContainer = PostProfileArgsContainer()

    override fun toString(): String {
        return super.toString() + argsContainer.username.navRoute(username)
    }
}