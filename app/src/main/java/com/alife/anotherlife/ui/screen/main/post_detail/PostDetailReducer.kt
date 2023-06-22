package com.alife.anotherlife.ui.screen.main.post_detail

import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.post_detail.mapper.BasePostDetailEntityToUIDetail
import com.alife.anotherlife.ui.screen.main.post_detail.model.ErrorLcePostDetailModelProvider
import com.alife.anotherlife.ui.screen.main.post_detail.state.PostDetailEffect
import com.alife.anotherlife.ui.screen.main.post_detail.state.PostDetailState
import com.alife.domain.main.map.BaseMapRepository
import javax.inject.Inject

class PostDetailReducer @Inject constructor(
    override val uiStore: UIStore<PostDetailState, PostDetailEffect>,
    private val postsEntityToUIDetail: BasePostDetailEntityToUIDetail,
    private val mapRepository: BaseMapRepository
) : HandlerBaseVMReducer<PostDetailState, PostDetailEffect>(), BasePostDetailReducer {

    override suspend fun onInit(username: String) {
        execute {
            setState { copy(lceModel = ErrorLcePostDetailModelProvider) }
        }.handle {
            val post = postsEntityToUIDetail.map(mapRepository.getPost(username))

            setState { copy(lceModel = LCEContent, uiPostDetail = post) }
        }
    }

    override suspend fun onUsername(username: String) {
        setEffect(PostDetailEffect.ToProfile(username))
    }
}