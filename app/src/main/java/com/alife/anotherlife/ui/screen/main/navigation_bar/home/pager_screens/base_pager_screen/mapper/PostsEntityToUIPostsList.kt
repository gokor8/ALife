package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.PageVerify
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIBadPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.UIPostsModelList
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.DefaultPostContainerUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.PicturePostContainerUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.PlzCreatePostContainerUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.UIBasePostContainer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.VideoPostContainerUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPlzCreatePostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPostModel
import com.alife.core.mapper.Mapper
import com.alife.domain.core.MappingException
import com.alife.domain.main.home.child.base_entity.BadPostEntity
import com.alife.domain.main.home.child.base_entity.ImagePostEntity
import com.alife.domain.main.home.child.base_entity.PostEntity
import com.alife.domain.main.home.child.base_entity.PostsEntity
import com.alife.domain.main.home.child.base_entity.VideoPostEntity
import javax.inject.Inject

interface BasePostsEntityToUIPostsList {
    fun map(pageVerify: PageVerify, posts: List<PostEntity>, isHavePostToday: Boolean): UIPostsModelList
}

class PostsEntityToUIPostsList @Inject constructor(
    private val emptyMapper: BasePostsEntityToEmptyUIPostModel
) : BasePostsEntityToUIPostsList {

    override fun map(pageVerify: PageVerify, posts: List<PostEntity>, isHavePostToday: Boolean): UIPostsModelList {
        return if(posts.isEmpty() && pageVerify.isPageFirst()) {
            listOf(emptyMapper.map(isHavePostToday))
        } else {
            posts.map { postEntity ->
                when (postEntity) {
                    is VideoPostEntity -> with(postEntity) {
                        VideoPostContainerUI(username, creationDate.toString(), avatar, video)
                    }
                    is ImagePostEntity -> with(postEntity) {
                        PicturePostContainerUI(username, creationDate.toString(), avatar, firstPhoto, secondPhoto)
                    }
                    is BadPostEntity -> with(postEntity) {
                        DefaultPostContainerUI(
                            UIBadPostModel(username, creationDate.toString(), avatar)
                        )
                    }
                    else -> throw MappingException()
                }
            }
        }.let { UIPostsModelList(it) }
    }
}