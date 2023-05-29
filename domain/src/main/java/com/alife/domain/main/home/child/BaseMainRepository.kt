package com.alife.domain.main.home.child

import com.alife.domain.main.home.child.base_entity.PostEntity

interface BaseMainRepository {

    suspend fun getPosts(page: Int): Pair<Int, List<PostEntity>>
}