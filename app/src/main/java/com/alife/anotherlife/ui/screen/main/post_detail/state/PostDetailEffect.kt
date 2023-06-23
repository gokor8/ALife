package com.alife.anotherlife.ui.screen.main.post_detail.state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.navigation.PostProfileNavigator
import com.alife.core.mvi.MVI

interface PostDetailEffect : MVI.Effect {

    class ToProfile(username: String) : PostDetailEffect,
        NavigationWrapper.Forward(PostProfileNavigator(username))
}