package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.main.create_alife.state.BaseSnackBarEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect

interface FinishPictureEffect : FinishEffect {

    class UploadPictureError : BaseSnackBarEffect.Abstract(R.string.upload_error), FinishPictureEffect
}