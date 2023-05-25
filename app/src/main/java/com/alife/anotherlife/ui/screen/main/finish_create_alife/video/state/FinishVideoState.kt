package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state

import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE

data class FinishVideoState(
    override val lceModel: LCEModel = LCELoading,
    val videoUrl: String = ""
) : StateLCE