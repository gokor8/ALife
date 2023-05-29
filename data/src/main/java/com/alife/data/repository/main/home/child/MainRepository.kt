package com.alife.data.repository.main.home.child

import androidx.paging.PagingSource
import com.alife.domain.main.home.child.BaseMainRepository
import com.alife.domain.main.home.child.base_entity.PostEntity
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val postsPaging: PagingSource<Int, PostEntity>
) : BaseMainRepository {

    override suspend fun getPosts(page: Int): Pair<Int, List<PostEntity>> {

    }
}