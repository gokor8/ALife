package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging

import androidx.paging.PagingSource
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BasePagingKeyMapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BasePostsEntityToUIPostsList
import com.alife.domain.main.BaseMyPostUseCase
import com.alife.domain.main.BasePostsUseCase
import javax.inject.Inject

interface BasePagingSourceFactory<PS : PagingSource<*, *>> {

    fun create(onLoadCallback: PagingLoadCallback): PS
}

class PostsPagingSourceFactory @Inject constructor(
    private val responseToEntity: BasePostsEntityToUIPostsList,
    private val postsUseCase: BasePostsUseCase,
    private val myPostUseCase: BaseMyPostUseCase,
    private val pagingKeyMapper: BasePagingKeyMapper
) : BasePagingSourceFactory<PostsPagingSource> {

    override fun create(onLoadCallback: PagingLoadCallback): PostsPagingSource {
        return PostsPagingSource(
            responseToEntity,
            postsUseCase,
            myPostUseCase,
            onLoadCallback,
            pagingKeyMapper
        )
    }
}