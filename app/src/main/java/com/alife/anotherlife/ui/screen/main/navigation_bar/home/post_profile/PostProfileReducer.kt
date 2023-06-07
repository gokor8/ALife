package com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile

import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state.PostEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state.PostState
import com.alife.domain.main.profile.BasePostProfileInfoUseCase
import javax.inject.Inject

class PostProfileReducer @Inject constructor(
    override val uiStore: UIStore<PostState, PostEffect>,
    private val postProfileInfoUSeCase: BasePostProfileInfoUseCase
) : HandlerBaseVMReducer<PostState, PostEffect>(), BasePostProfileReducer {

    override suspend fun onInit(username: String) {
        setState { copy(lceModel = LCELoading) }

        execute {

        }.handle {
            val user = postProfileInfoUSeCase.getUserInfo(username)

            setState {
                copy(
                    username = user.username,
                    name = user.name,
                    country = "",
                    description = user.description ?: ""
                )
            }
        }

        setState { copy(lceModel = LCEContent) }
    }
}