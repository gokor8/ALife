package com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state

import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.BaseLocationModel

interface FinishState<S : FinishState<S>> : StateLCE {

    val location: BaseLocationModel

    fun copyLocation(newLocationModel: BaseLocationModel): S

    fun copyLce(newLceModel: LCEModel): S
}