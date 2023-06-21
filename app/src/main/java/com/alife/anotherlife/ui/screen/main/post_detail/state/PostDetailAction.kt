package com.alife.anotherlife.ui.screen.main.post_detail.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.post_detail.BasePostDetailReducer

interface PostDetailAction : BaseMVIAction<BasePostDetailReducer> {

    class Init(private val username: String) : PostDetailAction {
        override suspend fun onAction(reducer: BasePostDetailReducer) {
            reducer.onInit(username)
        }
    }
}