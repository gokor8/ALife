package com.alife.domain.main

import com.alife.domain.main.home.child.BaseMainRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostsUseCase @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val mainRepository: BaseMainRepository
) : BasePostsUseCase {

    override suspend fun getPosts(page: Int) = withContext(dispatcher) {
        mainRepository.getPosts(page)
    }
}