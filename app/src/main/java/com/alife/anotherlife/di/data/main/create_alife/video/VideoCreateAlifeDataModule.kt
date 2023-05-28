package com.alife.anotherlife.di.data.main.create_alife.video

import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.BaseVideoCaptureBuilderFactory
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.VideoCaptureBuilderFactory
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.BaseVideoFinishExceptionMapper
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.VideoFinishExceptionMapper
import com.alife.data.repository.main.create_alife.CreateAlifeRepository
import com.alife.domain.main.create_alife.video.BaseVideoStorageAlifeUseCase
import com.alife.domain.main.create_alife.video.VideoStorageAlifeUseCase
import com.alife.domain.main.create_alife.video.repository.BaseCreateAlifeVideoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface VideoCreateAlifeDataModule {

    @Binds
    fun bindVideoStorageAlifeUseCase(videoAlifeUseCase: VideoStorageAlifeUseCase): BaseVideoStorageAlifeUseCase

    @Binds
    fun bindVideoFinishExceptionMapper(mapper: VideoFinishExceptionMapper): BaseVideoFinishExceptionMapper

    @Binds
    fun bindVideoCaptureBuilderFactory(videoCaptureFactory: VideoCaptureBuilderFactory): BaseVideoCaptureBuilderFactory

    @Binds
    fun bindCreateAlifeVideoRepository(repository: CreateAlifeRepository): BaseCreateAlifeVideoRepository

}