package com.alife.domain.main.home.child

import com.alife.domain.main.home.child.base_entity.PostsEntity

interface BaseMainRepository {

    suspend fun getPosts(page: Int, pageSize: Int): PostsEntity

    suspend fun getFriendsPosts(page: Int, pageSize: Int): PostsEntity

    suspend fun isHavePostToday(): Boolean
}