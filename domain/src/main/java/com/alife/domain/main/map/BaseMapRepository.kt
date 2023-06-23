package com.alife.domain.main.map

import com.alife.domain.main.home.child.base_entity.PostEntity

interface BaseMapRepository {

    suspend fun getMapPostList(): List<MapPostEntity>

    suspend fun getPost(username: String): PostEntity
}