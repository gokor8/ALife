package com.alife.anotherlife.ui.screen.main.post_detail

import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BasePostEntityToUIPost
import com.alife.anotherlife.ui.screen.main.post_detail.state.PostDetailEffect
import com.alife.anotherlife.ui.screen.main.post_detail.state.PostDetailState
import com.alife.domain.main.map.BaseMapRepository
import javax.inject.Inject

class PostDetailReducer @Inject constructor(
    override val uiStore: UIStore<PostDetailState, PostDetailEffect>,
    private val postsEntityToUIPostsList: BasePostEntityToUIPost,
    private val mapRepository: BaseMapRepository
) : AbstractVMReducer<PostDetailState, PostDetailEffect>(), BasePostDetailReducer {

    override suspend fun onInit(username: String) {
        postsEntityToUIPostsList.map(mapRepository.getPost(username))
    }
}