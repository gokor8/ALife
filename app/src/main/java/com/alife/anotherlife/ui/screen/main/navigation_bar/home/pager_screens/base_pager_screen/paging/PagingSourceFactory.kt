package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging

import androidx.paging.PagingSource
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BasePagingKeyMapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BasePostsEntityToUIPostsList
import com.alife.domain.main.BaseFriendsPostsUseCase
import com.alife.domain.main.BaseMyPostUseCase
import com.alife.domain.main.BasePostsUseCase
import com.alife.domain.main.BaseWorldPostsUseCase
import javax.inject.Inject

interface BasePagingSourceFactory<PS : PagingSource<*, *>> {

    fun create(onLoadCallback: PagingLoadCallback): PS


    abstract class Abstract(
        private val postsUseCase: BasePostsUseCase,
        private val responseToEntity: BasePostsEntityToUIPostsList,
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

    class World @Inject constructor(
        postsUseCase: BaseWorldPostsUseCase,
        responseToEntity: BasePostsEntityToUIPostsList,
        myPostUseCase: BaseMyPostUseCase,
        pagingKeyMapper: BasePagingKeyMapper
    ) : Abstract(postsUseCase, responseToEntity, myPostUseCase, pagingKeyMapper)

    class Friends @Inject constructor(
        postsUseCase: BaseFriendsPostsUseCase,
        responseToEntity: BasePostsEntityToUIPostsList,
        myPostUseCase: BaseMyPostUseCase,
        pagingKeyMapper: BasePagingKeyMapper
    ) : Abstract(postsUseCase, responseToEntity, myPostUseCase, pagingKeyMapper)
}