package com.alife.anotherlife.di.ui.main.profile

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.BasePostProfileReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.PostProfileReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.BaseProfileReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.ProfileReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.BaseProfileChangingReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.ProfileChangingReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.BaseProfileUsualReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.ProfileUsualReducer
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

    @Binds
    fun bindProfileReducer(reducer: ProfileReducer): BaseProfileReducer

    @Binds
    fun bindProfileUsualReducer(reducer: ProfileUsualReducer): BaseProfileUsualReducer

    @Binds
    fun bindProfileChangingReducer(reducer: ProfileChangingReducer): BaseProfileChangingReducer
}