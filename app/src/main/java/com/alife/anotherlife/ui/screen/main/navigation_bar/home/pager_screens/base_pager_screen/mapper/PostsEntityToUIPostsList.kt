package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.PageVerify
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIBadPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.UIPostsModelList
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.DefaultPostContainerUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.PicturePostContainerUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.VideoPostContainerUI
import com.alife.domain.core.MappingException
import com.alife.domain.main.home.child.base_entity.BadPostEntity
import com.alife.domain.main.home.child.base_entity.ImagePostEntity
import com.alife.domain.main.home.child.base_entity.PostEntity
import com.alife.domain.main.home.child.base_entity.VideoPostEntity
import javax.inject.Inject

interface BasePostsEntityToUIPostsList {
    fun map(
        pageVerify: PageVerify,
        posts: List<PostEntity>,
        isHavePostToday: Boolean
    ): UIPostsModelList
}

class PostsEntityToUIPostsList @Inject constructor(
    private val emptyMapper: BasePostsEntityToEmptyUIPostModel,
    private val dateAgoFormatMapper: BaseDateAgoFormatMapper
) : BasePostsEntityToUIPostsList {

    override fun map(
        pageVerify: PageVerify,
        posts: List<PostEntity>,
        isHavePostToday: Boolean
    ): UIPostsModelList {
        return if (posts.isEmpty() && pageVerify.isPageFirst()) {
            listOf(emptyMapper.map(isHavePostToday))
        } else {
            posts.map { postEntity ->
                val time = dateAgoFormatMapper.map(postEntity.creationDate)
                when (postEntity) {
                    is VideoPostEntity -> with(postEntity) {
                        VideoPostContainerUI(username, time, avatar, video)
                    }
                    is ImagePostEntity -> with(postEntity) {
                        PicturePostContainerUI(username, time, avatar, firstPhoto, secondPhoto)
                    }
                    is BadPostEntity -> with(postEntity) {
                        DefaultPostContainerUI(UIBadPostModel(username, time, avatar))
                    }
                    else -> throw MappingException()
                }
            }
        }.let { UIPostsModelList(it) }
    }
}