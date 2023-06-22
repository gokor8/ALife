package com.alife.anotherlife.ui.screen.main.navigation_bar.map.state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.main.post_detail.navigation.PostDetailNavigator
import com.alife.core.mvi.MVI

interface MapEffect : MVI.Effect {

    class OpenDetailScreen(username: String) : MapEffect, NavigationWrapper.Forward(
        PostDetailNavigator(username)
    )
}