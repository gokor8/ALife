package com.alife.anotherlife.core.composable.mvi_extensions

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.view_model.AbstractViewModel
import com.alife.core.mvi.MVI

abstract class DefaultViewModel<
REDUCER : BaseVMReducer<STATE, EFFECT>,
ACTION : BaseMVIAction<REDUCER>,
STATE : MVI.State,
EFFECT : MVI.Effect>(
    override val reducerVM: REDUCER,
) : AbstractViewModel<ACTION, STATE, EFFECT>() {

    override suspend fun onAction(action: ACTION) {
        action.onAction(reducerVM)
    }
}