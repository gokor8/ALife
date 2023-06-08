package com.alife.anotherlife.di.data.main.profile

import com.alife.data.repository.main.profile.ProfileRepository
import com.alife.data.repository.main.profile.mapper.BaseFileNameToSeparate
import com.alife.data.repository.main.profile.mapper.BaseProfileResponseToProfileEntity
import com.alife.data.repository.main.profile.mapper.BaseUriToFileName
import com.alife.data.repository.main.profile.mapper.BaseUriToTempFile
import com.alife.data.repository.main.profile.mapper.FileNameToSeparate
import com.alife.data.repository.main.profile.mapper.ProfileResponseToProfileEntity
import com.alife.data.repository.main.profile.mapper.UriToFileName
import com.alife.data.repository.main.profile.mapper.UriToTempFile
import com.alife.domain.main.profile.repository.BaseProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface ProfileDataModule {

    @Binds
    fun bindProfileRepository(repository: ProfileRepository): BaseProfileRepository

    @Binds
    fun bindProfileResponseToProfileEntity(mapper: ProfileResponseToProfileEntity)
            : BaseProfileResponseToProfileEntity

    @Binds
    fun bindUriToTempFile(mapper: UriToTempFile): BaseUriToTempFile

    @Binds
    fun bindUriToFileName(mapper: UriToFileName): BaseUriToFileName

    @Binds
    fun bindsFileNameToSeparate(mapper: FileNameToSeparate): BaseFileNameToSeparate
}