package com.alife.anotherlife.di.domain.main.finish_create_alife

import com.alife.domain.main.finish_create_alife.BasePhotoFinishLoadUseCase
import com.alife.domain.main.finish_create_alife.BaseVideoFinishLoadUseCase
import com.alife.domain.main.finish_create_alife.PhotoFinishLoadUseCase
import com.alife.domain.main.finish_create_alife.VideoFinishLoadUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface FinishCreateAlifeUseCaseModel {

    @Binds
    fun bindPhotoFinishLoadUseCase(useCase: PhotoFinishLoadUseCase): BasePhotoFinishLoadUseCase

    @Binds
    fun bindVideoFinishLoadUseCase(useCase: VideoFinishLoadUseCase): BaseVideoFinishLoadUseCase
}