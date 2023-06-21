package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.PageVerify
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.UIPostsModelList
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.DefaultPostContainerUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.PicturePostContainerUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.UIBasePostContainer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.VideoPostContainerUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIBadPostModel
import com.alife.core.mapper.Mapper
import com.alife.domain.core.MappingException
import com.alife.domain.main.home.child.base_entity.BadPostEntity
import com.alife.domain.main.home.child.base_entity.ImagePostEntity
import com.alife.domain.main.home.child.base_entity.PostEntity
import com.alife.domain.main.home.child.base_entity.VideoPostEntity
import javax.inject.Inject


interface BasePostEntityToUIPost : Mapper<PostEntity, UIBasePostContainer>

class PostEntityToUIPost @Inject constructor(
    private val dateAgoFormatMapper: BaseDateAgoFormatMapper
) : BasePostEntityToUIPost {

    override fun map(inputModel: PostEntity): UIBasePostContainer {
        val time = dateAgoFormatMapper.map(inputModel.creationDate)
        return when (inputModel) {
            is VideoPostEntity -> with(inputModel) {
                VideoPostContainerUI(username, time, avatar, video)
            }
            is ImagePostEntity -> with(inputModel) {
                PicturePostContainerUI(username, time, avatar, firstPhoto, secondPhoto)
            }
            is BadPostEntity -> with(inputModel) {
                DefaultPostContainerUI(UIBadPostModel(username, time, avatar))
            }
            else -> throw MappingException()
        }
    }
}