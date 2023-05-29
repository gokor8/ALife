package com.alife.data.data_source.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.home.child.model.PostsRequest
import com.alife.data.repository.main.home.child.model.PostsResponse
import com.alife.data.services.MainService
import com.alife.domain.main.home.child.base_entity.PostEntity
import com.alife.domain.main.home.child.base_entity.PostsEntity

class PostsPagingSource(
    private val responseToEntity: Mapper<PostsResponse, PostsEntity>,
    private val mainService: MainService,
): PagingSource<Int, PostEntity>() {

    override fun getRefreshKey(state: PagingState<Int, PostEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostEntity> {
        return try {
            val page = params.key ?: 1
            val response = mainService.getPosts(PostsRequest(page = page))

            val entity = responseToEntity.map(response)

            LoadResult.Page(
                data = entity.posts,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (entity.posts.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}