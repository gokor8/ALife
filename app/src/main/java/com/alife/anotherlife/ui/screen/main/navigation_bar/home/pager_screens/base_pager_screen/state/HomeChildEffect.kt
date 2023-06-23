package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state

import com.alife.anotherlife.R
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.navigation.CreateAlifeNavigator
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.SnackBarWrapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.navigation.PostProfileNavigator
import com.alife.core.mvi.MVI

interface HomeChildEffect : MVI.Effect, HomeStateEffect {

    class RequireInit : HomeChildEffect

    class NavigateToTakeALife : HomeChildEffect, NavigationWrapper.Forward(CreateAlifeNavigator())

    class NavigateToPostProfile(username: String) : HomeChildEffect,
        NavigationWrapper.Forward(PostProfileNavigator(username))

    class SnackBarPagingError : SnackBarWrapper(R.string.home_chile_paging_error_title),
        HomeChildEffect
}