package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BasePostsEntityToUIPostsList
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostsModelList
import com.alife.core.mapper.Mapper
import com.alife.domain.main.BasePostsUseCase
import com.alife.domain.main.home.child.base_entity.PostsEntity
import javax.inject.Inject

class PostsPagingSource @Inject constructor(
    private val responseToEntity: BasePostsEntityToUIPostsList,
    private val postsUseCase: BasePostsUseCase,
): PagingSource<Int, UIPostModel>() {

    override fun getRefreshKey(state: PagingState<Int, UIPostModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UIPostModel> {
        return try {
            val page = params.key ?: 1

            val entity = responseToEntity.map(postsUseCase.getPosts(page, params.loadSize))

            // TODO refactor to OOP
            LoadResult.Page(
                data = entity,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (entity.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}