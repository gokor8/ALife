package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FinishVideoViewModel @Inject constructor(
    reducer: BaseFinishVideoReducer
) : ViewModelLCE<BaseFinishVideoReducer, FinishVideoAction, FinishVideoState, FinishVideoEffect>(
    reducer
)