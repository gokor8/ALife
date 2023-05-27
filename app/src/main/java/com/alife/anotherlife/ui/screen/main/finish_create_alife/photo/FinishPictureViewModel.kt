package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo

import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishViewModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FinishPictureViewModel @Inject constructor(
    reducer: BaseFinishPictureReducer
) : ViewModelLCE<BaseFinishPictureReducer, FinishPictureAction, FinishPictureState, FinishEffect>(
    reducer
), BaseCreateFinishViewModel<BaseFinishPictureReducer, FinishPictureAction, FinishPictureState> {

    override fun reduceFinishAction(action: BaseFinishAction) {
        reduce(FinishPictureAction.OnBox(action))
    }
}