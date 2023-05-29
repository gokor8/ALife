package com.alife.domain.main.home.child

import com.alife.domain.main.home.child.base_entity.PostsEntity

interface BaseMainRepository {

    suspend fun getPosts(page: Int): PostsEntity
}