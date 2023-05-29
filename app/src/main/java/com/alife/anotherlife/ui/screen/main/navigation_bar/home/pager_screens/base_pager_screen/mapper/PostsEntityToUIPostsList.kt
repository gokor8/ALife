package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIBadPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPhotosPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPlzCreatePostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostsModelList
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIVideoPostModel
import com.alife.core.mapper.Mapper
import com.alife.domain.core.MappingException
import com.alife.domain.main.home.child.base_entity.BadPostEntity
import com.alife.domain.main.home.child.base_entity.ImagePostEntity
import com.alife.domain.main.home.child.base_entity.PostsEntity
import com.alife.domain.main.home.child.base_entity.VideoPostEntity
import javax.inject.Inject

interface BasePostsEntityToUIPostsList : Mapper<PostsEntity, UIPostsModelList>

class PostsEntityToUIPostsList @Inject constructor() : BasePostsEntityToUIPostsList {

    override fun map(inputModel: PostsEntity): UIPostsModelList {
        if (inputModel.posts.isEmpty()) return UIPostsModelList(UIPlzCreatePostModel())

        return inputModel.posts.map { postEntity ->
            when (postEntity) {
                is VideoPostEntity -> with(postEntity) {
                    UIVideoPostModel(username, date.toString(), avatar, video)
                }
                is ImagePostEntity -> with(postEntity) {
                    UIPhotosPostModel(username, date.toString(), avatar, firstPhoto, secondPhoto)
                }
                is BadPostEntity -> with(postEntity) {
                    UIBadPostModel(
                        username,
                        date.toString(),
                        avatar
                    )
                }
                else -> throw MappingException()
            }
        }.let { UIPostsModelList(it) }
    }
}