package com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state.PostEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state.PostState

interface BasePostProfileReducer : BaseVMReducer<PostState, PostEffect> {

    suspend fun onInit(username: String)
}