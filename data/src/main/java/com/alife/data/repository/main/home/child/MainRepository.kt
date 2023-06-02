package com.alife.data.repository.main.home.child

import com.alife.data.repository.main.home.child.mapper.BasePostsResponseToPostsEntity
import com.alife.data.services.MainService
import com.alife.domain.main.home.child.BaseMainRepository
import com.alife.domain.main.home.child.base_entity.ImagePostEntity
import com.alife.domain.main.home.child.base_entity.PostEntity
import com.alife.domain.main.home.child.base_entity.PostsEntity
import com.alife.domain.main.home.child.base_entity.VideoPostEntity
import java.util.Date
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val mainService: MainService,
    private val mapper: BasePostsResponseToPostsEntity
) : BaseMainRepository {

    override suspend fun getPosts(page: Int, pageSize: Int): PostsEntity {
        return mainService.getPosts(page, pageSize).let(mapper::map)
    }

    override suspend fun isHavePostToday() = mainService.getIsHavePostToday().isSuccessful
}