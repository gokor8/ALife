package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BasePagingKeyMapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BasePostsEntityToUIPostsList
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.PageVerify
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.UIPostsModelList
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.DefaultPostContainerUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.PlzCreatePostContainerUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.UIBasePostContainer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPlzCreatePostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPostModel
import com.alife.domain.main.BaseMyPostUseCase
import com.alife.domain.main.BasePostsUseCase
import java.io.IOException
import javax.inject.Inject

class PostsPagingSource @Inject constructor(
    private val responseToEntity: BasePostsEntityToUIPostsList,
    private val postsUseCase: BasePostsUseCase,
    private val myPostUseCase: BaseMyPostUseCase,
    private val pagingLoadCallback: PagingLoadCallback,
    private val pagingKeyMapper: BasePagingKeyMapper
) : PagingSource<Int, UIBasePostContainer>() {

    override fun getRefreshKey(state: PagingState<Int, UIBasePostContainer>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UIBasePostContainer> {
        return try {
            val page = params.key ?: 1

            val isHavePostToday = myPostUseCase.isHavePostToday()

            val postModelList = responseToEntity.map(
                PageVerify(page),
                postsUseCase.getPosts(page, 10).posts,//params.loadSize).posts,
                isHavePostToday
            )

            pagingLoadCallback.onLoad(isHavePostToday)

            LoadResult.Page(
                data = postModelList,
                prevKey = pagingKeyMapper.mapPreviousKey(postModelList, page),
                nextKey = pagingKeyMapper.mapNextKey(postModelList, page)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}