package com.alife.anotherlife.di.data.main.home

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.AppendErrorMapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BaseAppendErrorMapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BaseLoadStatesToStateEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.LoadStatesToStateEffect
import com.alife.data.repository.main.home.child.MainMockRepository
import com.alife.data.repository.main.home.child.MainRepository
import com.alife.data.repository.main.home.child.mapper.BasePostResponseToPostEntity
import com.alife.data.repository.main.home.child.mapper.BasePostsResponseToPostsEntity
import com.alife.data.repository.main.home.child.mapper.PostResponseToPostEntity
import com.alife.data.repository.main.home.child.mapper.PostsResponseToPostsEntity
import com.alife.domain.main.home.child.BaseMainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
interface HomeDataModule {

    @Binds
    fun bindMainRepository(repository: MainRepository): BaseMainRepository

    @Named("MockMainRepo")
    @Binds
    fun bindMainMockRepository(repository: MainMockRepository): BaseMainRepository

    @Binds
    fun bindPostsResponseToPostsEntity(mapper: PostsResponseToPostsEntity)
            : BasePostsResponseToPostsEntity

    @Binds
    fun bindPostResponseToPostEntity(mapper: PostResponseToPostEntity): BasePostResponseToPostEntity

//    @Binds
//    fun bindPostsResponseToPostsEntityMockImage(mapper: PostsResponseToPostsEntityMockImage)
//            : BasePostsResponseToPostsEntityMockImage

    @Binds
    fun bindLoadStatesToStateEffect(mapper: LoadStatesToStateEffect): BaseLoadStatesToStateEffect

    @Binds
    fun bindAppendErrorMapper(mapper: AppendErrorMapper): BaseAppendErrorMapper
}