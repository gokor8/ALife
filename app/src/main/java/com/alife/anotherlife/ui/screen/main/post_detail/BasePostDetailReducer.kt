package com.alife.anotherlife.ui.screen.main.post_detail

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.post_detail.state.PostDetailEffect
import com.alife.anotherlife.ui.screen.main.post_detail.state.PostDetailState

interface BasePostDetailReducer : BaseVMReducer<PostDetailState, PostDetailEffect> {

    suspend fun onInit(username: String)

    suspend fun onUsername(username: String)
}