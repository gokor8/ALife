package com.alife.anotherlife.di.ui.main.home

import androidx.paging.PagingSource
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.BaseHomeReducerBase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.HomeReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.model.TabsVisibilityContract
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BasePagingKeyMapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BasePostsEntityToEmptyUIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging.PostsPagingSource
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BasePostsEntityToUIPostsList
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.PagingKeyMapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.PostsEntityToEmptyUIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.PostsEntityToUIPostsList
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.ProfileCardEntityToUICard
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.UIBasePostContainer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPostModel
import com.alife.core.mapper.Mapper
import com.alife.domain.main.home.child.ProfileCardEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface HomeViewModelModule {

    @Binds
    fun bindHomeReducer(reducer: HomeReducer): BaseHomeReducerBase

    @Binds
    fun bindBaseHomeReducerBase(reducer: HomeReducer): TabsVisibilityContract

    @Binds
    fun bindProfileCardEntityToUICard(
        mapper: ProfileCardEntityToUICard
    ): Mapper<ProfileCardEntity, UIPostModel>

    @Binds
    fun bindPostsEntityToUIPostsList(mapper: PostsEntityToUIPostsList): BasePostsEntityToUIPostsList

    @Binds
    fun bindPostsEntityToEmptyUIPostModel(mapper: PostsEntityToEmptyUIPostModel)
            : BasePostsEntityToEmptyUIPostModel

    @Binds
    fun bindPaging(paging: PostsPagingSource): PagingSource<Int, UIBasePostContainer>

//    @Binds
//    fun bindPostsPagingSourceFactory(pagingSource: PostsPagingSourceFactory)
//            : BasePagingSourceFactory<PostsPagingSource>

    @Binds
    fun bindPagingKeyMapper(mapper: PagingKeyMapper): BasePagingKeyMapper
}