package com.alife.anotherlife.di.ui.main.profile

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.BasePostProfileReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.PostProfileReducer
import com.alife.core.addons.Reducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface ProfileViewModelModule {

    @Binds
    fun bindPostProfileReducer(reducer: PostProfileReducer): BasePostProfileReducer
}