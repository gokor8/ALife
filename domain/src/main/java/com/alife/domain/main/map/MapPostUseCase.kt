package com.alife.domain.main.map

import com.alife.domain.core.usecase.AbstractUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

interface BaseMapPostUseCase {

    suspend fun getMapPosts(): List<MapPostEntity>
}

class MapPostUseCase @Inject constructor(
    override val dispatcher: CoroutineDispatcher,
    private val mapRepository: BaseMapRepository,
): AbstractUseCase(), BaseMapPostUseCase {

    override suspend fun getMapPosts() = withIO {
        mapRepository.getMapPostList()
    }
}