package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.SnackBarWrapper
import com.alife.core.mvi.MVI

interface ProfileEffect : MVI.Effect {

    class ProfilePhotoUploadError : SnackBarWrapper(R.string.profile_error_load_photo), ProfileEffect

    class ProfileInfoUploadError : SnackBarWrapper(R.string.profile_error_load_info), ProfileEffect
}