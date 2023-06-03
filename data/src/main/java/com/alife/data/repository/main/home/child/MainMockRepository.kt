package com.alife.data.repository.main.home.child

import com.alife.data.services.MockImageService
import com.alife.domain.main.home.child.BaseMainRepository
import com.alife.domain.main.home.child.base_entity.ImagePostEntity
import com.alife.domain.main.home.child.base_entity.PostEntity
import com.alife.domain.main.home.child.base_entity.PostsEntity
import com.alife.domain.main.home.child.base_entity.VideoPostEntity
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.io.IOException
import java.util.Date
import javax.inject.Inject

class MainMockRepository @Inject constructor(
    private val mockImageService: MockImageService
) : BaseMainRepository {

    private var counter = 0

    override suspend fun isHavePostToday(): Boolean {
        if(counter != 16) ++counter
        return counter % 16 == 0
    }

    override suspend fun getPosts(page: Int, pageSize: Int): PostsEntity {
        delay(1000L)

        // TODO Сделать повтор запроса, при ошибке
        if (page == 16)
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
    }
}