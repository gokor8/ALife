package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state

import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE

data class FinishPictureState(
    override val lceModel: LCEModel = LCELoading,
    val firstImageUrl: String = "",
    val secondImageUrl: String = ""
) : StateLCE {

    fun isUrlsValid() = firstImageUrl.isNotEmpty() && secondImageUrl.isNotEmpty()
}