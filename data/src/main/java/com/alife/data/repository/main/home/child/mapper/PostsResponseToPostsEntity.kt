package com.alife.data.repository.main.home.child.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.home.child.model.PostsResponse
import com.alife.domain.main.home.child.base_entity.BadPostEntity
import com.alife.domain.main.home.child.base_entity.ImagePostEntity
import com.alife.domain.main.home.child.base_entity.PostEntity
import com.alife.domain.main.home.child.base_entity.PostsEntity
import com.alife.domain.main.home.child.base_entity.VideoPostEntity
import java.util.Date
import javax.inject.Inject

interface BasePostsResponseToPostsEntity : Mapper<PostsResponse, PostsEntity>

class PostsResponseToPostsEntity @Inject constructor(
    private val postResponseToPostEntity: BasePostResponseToPostEntity
) : BasePostsResponseToPostsEntity {

    override fun map(inputModel: PostsResponse) =
        PostsEntity(
            inputModel.results.map { postResponse ->
                postResponseToPostEntity.map(postResponse)
            }
        )
}