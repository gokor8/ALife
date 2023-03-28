package com.alife.anotherlife.di.ui.main.home

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.BaseHomeReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.HomeReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.ProfileCardEntityToUICard
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UICardModel
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
    fun bindHomeReducer(reducer: HomeReducer): BaseHomeReducer

    @Binds
    fun bindProfileCardEntityToUICard(
        mapper: ProfileCardEntityToUICard
    ): Mapper<ProfileCardEntity, UICardModel>
}