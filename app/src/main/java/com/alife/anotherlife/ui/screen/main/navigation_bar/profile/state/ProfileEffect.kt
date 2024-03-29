package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state

import com.alife.anotherlife.R
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.login.navigation.LoginNavigator
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.SnackBarWrapper
import com.alife.core.mvi.MVI

interface ProfileEffect : MVI.Effect {

    class ProfilePhotoUploadError : SnackBarWrapper(R.string.profile_error_load_photo), ProfileEffect

    class ProfileInfoUploadError : SnackBarWrapper(R.string.profile_error_load_info), ProfileEffect

    class ProfileExitError : SnackBarWrapper(R.string.profile_error_exit), ProfileEffect

    class Exit : ProfileEffect, NavigationWrapper.ForwardNewGraphClearAll(LoginNavigator())
}