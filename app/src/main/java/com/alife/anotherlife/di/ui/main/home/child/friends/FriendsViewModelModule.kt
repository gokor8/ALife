package com.alife.anotherlife.di.ui.main.home.child.friends

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildReducerBase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.friends.FriendsReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface FriendsViewModelModule {

    @Binds
    fun bindFriendsReducer(reducer: FriendsReducer): AbstractHomeChildReducerBase
}