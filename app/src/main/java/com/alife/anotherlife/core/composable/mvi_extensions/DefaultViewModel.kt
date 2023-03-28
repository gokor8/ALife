package com.alife.anotherlife.core.composable.mvi_extensions

import com.alife.anotherlife.core.ui.reducer.VMReducer
import com.alife.anotherlife.core.ui.view_model.BaseViewModel
import com.alife.core.mvi.MVI

abstract class DefaultViewModel<
REDUCER : VMReducer<STATE, EFFECT>,
ACTION : BaseMVIAction<REDUCER>,
STATE : MVI.State,
EFFECT : MVI.Effect>(
    override val reducerVM: REDUCER,
) : BaseViewModel<ACTION, STATE, EFFECT>() {

    override suspend fun onAction(action: ACTION) {
        action.onAction(reducerVM)
    }
}