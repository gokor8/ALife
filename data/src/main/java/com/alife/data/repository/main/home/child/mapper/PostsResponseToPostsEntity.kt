package com.alife.data.repository.main.home.child.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.home.child.model.PostsResponse
import com.alife.domain.main.home.child.base_entity.BadPostEntity
import com.alife.domain.main.home.child.base_entity.ImagePostEntity
import com.alife.domain.main.home.child.base_entity.PostsEntity
import com.alife.domain.main.home.child.base_entity.VideoPostEntity
import java.util.Date
import javax.inject.Inject

interface BasePostsResponseToPostsEntity : Mapper<PostsResponse, PostsEntity>

class PostsResponseToPostsEntity @Inject constructor() : BasePostsResponseToPostsEntity {

    override fun map(inputModel: PostsResponse): PostsEntity {
        return PostsEntity(inputModel.results.map { postResponse ->
            with(postResponse) {
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
        })
    }
}