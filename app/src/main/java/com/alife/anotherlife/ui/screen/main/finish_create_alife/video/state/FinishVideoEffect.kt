package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state

import com.alife.anotherlife.R
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.BaseSnackBarEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.SnackBarWrapper
import com.alife.core.mvi.MVI

interface FinishVideoEffect : FinishEffect {

    class UploadVideoError : SnackBarWrapper(R.string.upload_error_video), FinishVideoEffect
}