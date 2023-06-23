package com.alife.domain.main.map

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.main.home.child.base_entity.PostEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

interface BaseMapPostUseCase {

    suspend fun getMapPosts(): List<MapPostEntity>

    suspend fun getMapPost(username: String): PostEntity
}

class MapPostUseCase @Inject constructor(
    override val dispatcher: CoroutineDispatcher,
    private val mapRepository: BaseMapRepository,
): AbstractUseCase(), BaseMapPostUseCase {

    override suspend fun getMapPosts() = withIO {
        mapRepository.getMapPostList()
    }

    override suspend fun getMapPost(username: String) = withIO {
        mapRepository.getPost(username)
    }
}