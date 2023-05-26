package com.alife.anotherlife.ui.screen.main.finish_create_alife

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.core.ui.view_model.BaseViewModelLCE
import com.alife.core.mvi.MVI

interface BaseCreateFinishViewModel<
  REDUCER : BaseCreateFinishReducer<STATE, EFFECT>,
  ACTION : BaseMVIAction<REDUCER>,
  STATE : StateLCE,
  EFFECT : MVI.Effect
> : BaseViewModelLCE<REDUCER, ACTION, STATE, EFFECT> {

    fun reduceFinishAction(action: BaseCreateFinishAction)
}