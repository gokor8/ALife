package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state

import com.alife.anotherlife.R
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.BaseSnackBarEffect
import com.alife.core.mvi.MVI

interface FinishPictureEffect : MVI.Effect {

    class UploadPictureError : BaseSnackBarEffect.Abstract(R.string.upload_error), FinishPictureEffect

    class GoBack : FinishPictureEffect, NavigationWrapper.Back()
}