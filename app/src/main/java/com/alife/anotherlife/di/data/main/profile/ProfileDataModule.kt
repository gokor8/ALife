package com.alife.anotherlife.di.data.main.profile

import com.alife.data.repository.main.profile.ProfileRepository
import com.alife.domain.main.profile.repository.BaseProfileRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface ProfileDataModule {

    fun bindProfileRepository(repository: ProfileRepository): BaseProfileRepository
}