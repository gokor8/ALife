package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state

import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.model.UIPicturesModel

data class FinishPictureState(
    override val lceModel: LCEModel = LCELoading,
    val uiPicturesModel: UIPicturesModel? = null
) : StateLCE