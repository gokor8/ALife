package com.alife.anotherlife.di.domain.main.profile

import com.alife.domain.main.profile.BasePostProfileInfoUseCase
import com.alife.domain.main.profile.PostProfileInfoUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
interface ProfileDomainModule {

    @Binds
    fun bindPostProfileInfoUseCase(useCase: PostProfileInfoUseCase): BasePostProfileInfoUseCase
}