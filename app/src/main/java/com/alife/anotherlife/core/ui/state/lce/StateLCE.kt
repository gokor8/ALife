package com.alife.anotherlife.core.ui.state.lce

import com.alife.core.mvi.MVI

interface StateLCE : MVI.State {
    val lceModel: LCEModel
}