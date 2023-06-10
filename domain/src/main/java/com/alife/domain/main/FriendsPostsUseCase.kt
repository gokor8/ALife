package com.alife.domain.main

import com.alife.domain.main.home.child.BaseMainRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface BaseFriendsPostsUseCase : BasePostsUseCase

class FriendsPostsUseCase @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val mainRepository: BaseMainRepository
) : BaseFriendsPostsUseCase {

    override suspend fun getPosts(page: Int, pageSize: Int) = withContext(dispatcher) {
        mainRepository.getFriendsPosts(page, pageSize)
    }
}