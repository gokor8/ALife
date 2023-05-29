package com.alife.anotherlife.di.ui.main.home

import androidx.paging.PagingSource
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.BaseHomeReducerBase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.HomeReducerBase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.PostsPagingSource
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BasePostsEntityToUIPostsList
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.PostsEntityToUIPostsList
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.ProfileCardEntityToUICard
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
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
    fun bindHomeReducer(reducer: HomeReducerBase): BaseHomeReducerBase

    @Binds
    fun bindProfileCardEntityToUICard(
        mapper: ProfileCardEntityToUICard
    ): Mapper<ProfileCardEntity, UIPostModel>

    @Binds
    fun bindPostsEntityToUIPostsList(mapper: PostsEntityToUIPostsList): BasePostsEntityToUIPostsList

    @Binds
    fun bindPaging(paging: PostsPagingSource): PagingSource<Int, UIPostModel>
}