package com.alife.anotherlife.ui.screen.main.finish_create_alife

import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.core.ui.view_model.BaseViewModelLCE
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishState
import com.alife.core.mvi.MVI

interface BaseCreateFinishViewModel<
        REDUCER : BaseCreateFinishReducer<STATE>,
        ACTION : BaseMVIAction<REDUCER>,
        STATE : FinishState<STATE>> : BaseViewModelLCE<REDUCER, ACTION, STATE, FinishEffect> {

    fun reduceFinishAction(action: BaseFinishAction)

    override suspend fun onEffect(navController: NavController, effect: FinishEffect) {
        if(effect is FinishEffect.Retry)
            reduceFinishAction(BaseFinishAction.Init())
        else
            super.onEffect(navController, effect)
    }
}