package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishViewModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FinishVideoViewModel @Inject constructor(
    reducer: BaseFinishVideoReducer
) : BaseCreateFinishViewModel.Abstract<BaseFinishVideoReducer, FinishVideoAction, FinishVideoState>(
    reducer
) {

    override fun reduceFinishAction(action: BaseFinishAction) {
        reduce(FinishVideoAction.OnBox(action))
    }
}