package com.alife.data.repository.main.map

import com.alife.data.repository.main.map.mapper.BaseMapPostDataModelToEntity
import com.alife.data.repository.main.map.mapper.BaseMapPostsDataModelToEntity
import com.alife.data.services.MapService
import com.alife.domain.main.home.child.base_entity.PostEntity
import com.alife.domain.main.home.child.base_entity.PostsEntity
import com.alife.domain.main.map.BaseMapRepository
import com.alife.domain.main.map.MapPostEntity
import javax.inject.Inject

class MapRepository @Inject constructor(
    private val mapPostDataModelToEntity: BaseMapPostDataModelToEntity,
    private val mapPostsDataModelToEntity: BaseMapPostsDataModelToEntity,
    private val mapService: MapService
) : BaseMapRepository {

    private var cacheMapPosts = PostsEntity(listOf())

    override suspend fun getMapPostList(): List<MapPostEntity> {
        val response = mapService.getMapPosts()

        cacheMapPosts = mapPostsDataModelToEntity.map(response)

        return mapPostDataModelToEntity.map(response)
    }

    override suspend fun getPost(username: String): PostEntity {
        return cacheMapPosts.posts.first { post -> post.username == username }
    }
}