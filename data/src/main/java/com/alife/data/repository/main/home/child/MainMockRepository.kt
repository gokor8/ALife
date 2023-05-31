package com.alife.data.repository.main.home.child

import com.alife.data.repository.main.home.child.mapper.BasePostsResponseToPostsEntityMockImage
import com.alife.data.services.MainService
import com.alife.data.services.MockImageService
import com.alife.domain.main.home.child.BaseMainRepository
import com.alife.domain.main.home.child.base_entity.ImagePostEntity
import com.alife.domain.main.home.child.base_entity.PostEntity
import com.alife.domain.main.home.child.base_entity.PostsEntity
import com.alife.domain.main.home.child.base_entity.VideoPostEntity
import kotlinx.coroutines.delay
import java.io.IOException
import java.util.Date
import javax.inject.Inject

class MainMockRepository @Inject constructor(
    private val mainService: MainService,
    private val mockImageService: MockImageService,
    private val mapper: BasePostsResponseToPostsEntityMockImage
) : BaseMainRepository {

    override suspend fun getPosts(page: Int, pageSize: Int): PostsEntity {
        delay(1000L)

        // TODO Сделать повтор запроса, при ошибке
        if(page == 8)
            throw IOException()

        return PostsEntity(
            listOf<PostEntity>(
                ImagePostEntity(
                    "Aboba$page",
                    Date(),
                    mockImageService.getImage().url,
                    mockImageService.getImage().url,
                    mockImageService.getImage().url
                ),
                VideoPostEntity(
                    "Oleg$page",
                    Date(),
                    mockImageService.getImage().url,
                    mockImageService.getImage().url
                )
            )
        )
        //        return mapper.map(
//            mainService.getPosts(page, pageSize),
//            mockImageService.getImage().url,
//            mockImageService.getImage().url,
//            mockImageService.getImage().url
//        )
    }
}