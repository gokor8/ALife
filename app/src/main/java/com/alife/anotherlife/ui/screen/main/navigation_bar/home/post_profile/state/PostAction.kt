package com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state

import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.BasePostProfileReducer

interface PostAction : BaseMVIAction<BasePostProfileReducer> {

    class OnInit(private val username: String) : PostAction {
        override suspend fun onAction(reducer: BasePostProfileReducer) {
            reducer.onInit(username)
        }
    }
}