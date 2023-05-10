package com.alife.anotherlife.core.ui.view_model

import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.core.mvi.MVI

abstract class ViewModelLCE<ACTION : MVI.Action, STATE : StateLCE, EFFECT : MVI.Effect>
    : AbstractViewModel<ACTION, STATE, EFFECT>()