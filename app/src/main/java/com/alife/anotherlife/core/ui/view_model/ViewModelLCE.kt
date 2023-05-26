package com.alife.anotherlife.core.ui.view_model

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.core.composable.mvi_extensions.DefaultViewModel
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.reducer.ReducerCoroutineHandler
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.core.mvi.MVI

interface BaseViewModelLCE<
  REDUCER : BaseVMReducer<STATE, EFFECT>,
  ACTION : BaseMVIAction<REDUCER>,
  STATE : StateLCE,
  EFFECT : MVI.Effect
> : BaseViewModel<ACTION, STATE, EFFECT>

abstract class ViewModelLCE<
  REDUCER : BaseVMReducer<STATE, EFFECT>,
  ACTION : BaseMVIAction<REDUCER>, STATE : StateLCE, EFFECT : MVI.Effect
>(reducerVM: REDUCER) : DefaultViewModel<REDUCER, ACTION, STATE, EFFECT>(reducerVM),
    BaseViewModelLCE<REDUCER, ACTION, STATE, EFFECT>