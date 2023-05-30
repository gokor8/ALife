package com.alife.data.repository.main.home.child

import com.alife.data.repository.main.home.child.mapper.BasePostsResponseToPostsEntityMockImage
import com.alife.data.services.MainService
import com.alife.data.services.MockImageService
import com.alife.domain.main.home.child.BaseMainRepository
import com.alife.domain.main.home.child.base_entity.PostsEntity
import kotlinx.coroutines.delay
import javax.inject.Inject

class MainMockRepository @Inject constructor(
    private val mainService: MainService,
    private val mockImageService: MockImageService,
    private val mapper: BasePostsResponseToPostsEntityMockImage
) : BaseMainRepository {

    override suspend fun getPosts(page: Int, pageSize: Int): PostsEntity {
        delay(3000L)
        return mapper.map(
            mainService.getPosts(page, pageSize),
            mockImageService.getImage().url,
            mockImageService.getImage().url,
            mockImageService.getImage().url
        )
    }
}