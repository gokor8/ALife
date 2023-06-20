package com.alife.anotherlife.di.ui.main.profile

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state.PostEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state.PostState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state.ProfileUsualEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state.ProfileUsualState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.InitUIProfileInfoModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProfileViewModelModuleP {

    @Singleton
    @Provides
    fun provideProfilePost(): UIStore<PostState, PostEffect> = DefaultUIStore(PostState())

    @Singleton
    @Provides
    fun provideProfileChanging(): UIStore<ProfileChangingState, ProfileEffect> {
        return DefaultUIStore(ProfileChangingState(InitUIProfileInfoModel()))
    }

    @Singleton
    @Provides
    fun provideProfileState(): UIStore<ProfileState, ProfileEffect> {
        return DefaultUIStore(ProfileState())
    }

    @Singleton
    @Provides
    fun provideProfileUsual(): UIStore<ProfileUsualState, ProfileUsualEffect> {
        return DefaultUIStore(ProfileUsualState(InitUIProfileInfoModel()))
    }
}

