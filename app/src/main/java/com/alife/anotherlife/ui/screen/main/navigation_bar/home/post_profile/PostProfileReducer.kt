package com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile

import com.alife.anotherlife.core.ui.image.ImageExtModel
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state.PostEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state.PostState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.EmptyImageExtModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.UIProfileInfoModel
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

            val photo = if (user.pictureUrl == null)
                EmptyImageExtModel()
            else
                ImageExtModel.Uri(user.pictureUrl!!)

            setState {
                copy(
                    uiProfileInfoModel = UIProfileInfoModel(
                        username = user.username,
                        name = user.name,
                        description = user.description ?: "",
                        photo = photo
                    )
                )
            }
        }

        setState { copy(lceModel = LCEContent) }
    }
}