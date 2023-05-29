package com.alife.data.repository.main.home.child

import com.alife.domain.main.home.child.BaseMainRepository
import com.alife.domain.main.home.child.base_entity.ImagePostEntity
import com.alife.domain.main.home.child.base_entity.PostEntity
import com.alife.domain.main.home.child.base_entity.PostsEntity
import com.alife.domain.main.home.child.base_entity.VideoPostEntity
import java.util.Date
import javax.inject.Inject

class MainRepository @Inject constructor() : BaseMainRepository {

    override suspend fun getPosts(page: Int): PostsEntity {
        return PostsEntity(
            listOf<PostEntity>(
                ImagePostEntity("Aboba", Date(), "", Date(), "", ""),
                VideoPostEntity("Oleg", Date(), "", Date(), "")
            )
        )
    }
}