package com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state

import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE

interface FinishState<S : FinishState<S>> : StateLCE {

    fun copyLce(newLceModel: LCEModel): S
}