package com.alife.data.repository.main.map.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.home.child.mapper.BasePostResponseToPostEntity
import com.alife.data.repository.main.map.model.MapPostsDataModel
import com.alife.domain.main.home.child.base_entity.PostsEntity
import javax.inject.Inject

interface BaseMapPostsDataModelToEntity : Mapper<MapPostsDataModel, PostsEntity>

class MapPostsDataModelToEntity @Inject constructor(
    private val postResponseToPostEntity: BasePostResponseToPostEntity
) : BaseMapPostsDataModelToEntity {

    override fun map(inputModel: MapPostsDataModel) =
        PostsEntity(
            inputModel.map { postResponse ->
                postResponseToPostEntity.map(postResponse)
            }
        )
}