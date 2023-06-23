package com.alife.anotherlife.ui.screen.main.post_detail

import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.post_detail.state.PostDetailAction
import com.alife.anotherlife.ui.screen.main.post_detail.state.PostDetailEffect
import com.alife.anotherlife.ui.screen.main.post_detail.state.PostDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    reducer: BasePostDetailReducer
) : ViewModelLCE<BasePostDetailReducer, PostDetailAction, PostDetailState, PostDetailEffect>(reducer)