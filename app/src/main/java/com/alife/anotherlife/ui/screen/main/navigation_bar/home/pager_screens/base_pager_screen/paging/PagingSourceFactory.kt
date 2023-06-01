package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging

import androidx.paging.PagingSource
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BasePostsEntityToUIPostsList
import com.alife.domain.main.BasePostsUseCase
import javax.inject.Inject

interface BasePagingSourceFactory<PS : PagingSource<*, *>> {

    fun create(): PS
}

class PostsPagingSourceFactory @Inject constructor(
    private val responseToEntity: BasePostsEntityToUIPostsList,
    private val postsUseCase: BasePostsUseCase
) : BasePagingSourceFactory<PostsPagingSource> {

    override fun create(): PostsPagingSource {
        return PostsPagingSource(responseToEntity, postsUseCase)
    }
}