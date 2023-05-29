package com.alife.domain.main

import com.alife.domain.main.home.child.base_entity.PostsEntity

interface BasePostsUseCase {

    suspend fun getPosts(page: Int, pageSize: Int): PostsEntity
}