package com.alife.data.repository.main.home.child.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.home.child.model.BasePostResponse
import com.alife.domain.main.home.child.base_entity.BadPostEntity
import com.alife.domain.main.home.child.base_entity.ImagePostEntity
import com.alife.domain.main.home.child.base_entity.PostEntity
import com.alife.domain.main.home.child.base_entity.VideoPostEntity
import java.util.Date
import javax.inject.Inject

interface BasePostResponseToPostEntity : Mapper<BasePostResponse, PostEntity>

class PostResponseToPostEntity @Inject constructor(): BasePostResponseToPostEntity {
    override fun map(inputModel: BasePostResponse) = with(inputModel) {
        val photos = getPhotos()
        val creationDate = Date(creationDate)
        when {
            photos != null -> ImagePostEntity(
                username,
                creationDate,
                profilePhoto,
                photos.first,
                photos.second
            )

            video != null -> VideoPostEntity(username, creationDate, profilePhoto, video)
            else -> BadPostEntity(username, creationDate, profilePhoto)
        }
    }
}