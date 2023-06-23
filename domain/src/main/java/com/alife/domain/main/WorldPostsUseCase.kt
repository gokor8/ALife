package com.alife.domain.main

import com.alife.domain.main.home.child.BaseMainRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface BaseWorldPostsUseCase : BasePostsUseCase

class WorldPostsUseCase @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    //@Named("MockMainRepo")
    private val mainRepository: BaseMainRepository
) : BaseWorldPostsUseCase {

    override suspend fun getPosts(page: Int, pageSize: Int) = withContext(dispatcher) {
        mainRepository.getPosts(page, pageSize)
    }
}