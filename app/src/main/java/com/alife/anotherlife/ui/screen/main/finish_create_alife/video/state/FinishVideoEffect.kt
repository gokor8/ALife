package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state

import com.alife.anotherlife.R
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.BaseSnackBarEffect
import com.alife.core.mvi.MVI

interface FinishVideoEffect : MVI.Effect {

    class UploadVideoError : BaseSnackBarEffect.Abstract(R.string.upload_error), FinishVideoEffect

    class GoBack : FinishVideoEffect, NavigationWrapper.Back()
}