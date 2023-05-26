package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo

import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishViewModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureState
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoAction
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FinishPictureViewModel @Inject constructor(
    reducer: BaseFinishPictureReducer
) : ViewModelLCE<BaseFinishPictureReducer, FinishPictureAction, FinishPictureState, FinishPictureEffect>(
    reducer
), BaseCreateFinishViewModel<BaseFinishPictureReducer, FinishPictureAction, FinishPictureState, FinishPictureEffect> {

    override fun reduceFinishAction(action: BaseCreateFinishAction) {
        reduce(FinishPictureAction.onBox(action))
    }
}