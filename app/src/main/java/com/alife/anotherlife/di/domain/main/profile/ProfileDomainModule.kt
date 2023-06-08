package com.alife.anotherlife.di.domain.main.profile

import com.alife.domain.main.profile.BasePostProfileInfoUseCase
import com.alife.domain.main.profile.BaseReadNewProfilePhotoUseCase
import com.alife.domain.main.profile.BaseSaveProfileDataUseCase
import com.alife.domain.main.profile.BaseUserProfileInfoUseCase
import com.alife.domain.main.profile.PostProfileInfoUseCase
import com.alife.domain.main.profile.SaveProfileDataUseCase
import com.alife.domain.main.profile.UserProfileInfoUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
interface ProfileDomainModule {

    @Binds
    fun bindPostProfileInfoUseCase(useCase: PostProfileInfoUseCase): BasePostProfileInfoUseCase

    @Binds
    fun bindUserProfileInfoUseCase(useCase: UserProfileInfoUseCase): BaseUserProfileInfoUseCase

    @Binds
    fun bindSaveProfileDataUseCase(useCase: SaveProfileDataUseCase): BaseSaveProfileDataUseCase
}