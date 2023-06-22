package com.alife.anotherlife.ui.screen.main.post_detail.mapper

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BaseDateAgoFormatMapper
import com.alife.anotherlife.ui.screen.main.post_detail.model.BaseUIPostDetail
import com.alife.anotherlife.ui.screen.main.post_detail.model.UIPostMedia
import com.alife.core.mapper.Mapper
import com.alife.domain.core.MappingException
import com.alife.domain.main.home.child.base_entity.ImagePostEntity
import com.alife.domain.main.home.child.base_entity.PostEntity
import com.alife.domain.main.home.child.base_entity.VideoPostEntity
import javax.inject.Inject

interface BasePostDetailEntityToUIDetail : Mapper<PostEntity, BaseUIPostDetail>

class PostDetailEntityToUIDetail @Inject constructor(
    private val dateAgoFormatMapper: BaseDateAgoFormatMapper
) : BasePostDetailEntityToUIDetail {

    override fun map(inputModel: PostEntity): BaseUIPostDetail {
        val time = dateAgoFormatMapper.map(inputModel.creationDate)
        return when (inputModel) {
            is VideoPostEntity -> with(inputModel) {
                BaseUIPostDetail.UIPostDetail(username, time, avatar, UIPostMedia.Video(video))
            }
            is ImagePostEntity -> with(inputModel) {
                BaseUIPostDetail.UIPostDetail(username, time, avatar, UIPostMedia.Photos(firstPhoto, secondPhoto))
            }
            else -> throw MappingException()
        }
    }
}