package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state

import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishState
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureState

data class FinishVideoState(
    override val lceModel: LCEModel = LCELoading,
    val videoUrl: String = ""
) : FinishState<FinishVideoState> {

    override fun copyLce(newLceModel: LCEModel) = copy(lceModel = newLceModel)
}