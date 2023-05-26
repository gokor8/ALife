package com.alife.anotherlife.di.ui.main.create_alife

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.DefaultVideoCaptureFactory
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.BaseVideoCaptureBuilderFactory
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.VideoCaptureBuilderFactory
import com.alife.data.repository.main.create_alife.CreateAlifeRepository
import com.alife.data.repository.main.create_alife.picture.mapper.BaseEntityToReadModel
import com.alife.data.repository.main.create_alife.picture.mapper.BaseEntityToSaveModel
import com.alife.data.repository.main.create_alife.picture.mapper.EntityToReadModel
import com.alife.data.repository.main.create_alife.picture.mapper.EntityToSaveModel
import com.alife.domain.main.create_alife.picture.BasePhotoStorageAlifeUseCase
import com.alife.domain.main.create_alife.picture.BaseSaveAlifeUseCase
import com.alife.domain.main.create_alife.picture.PhotoStorageAlifeUseCase
import com.alife.domain.main.create_alife.picture.SaveAlifeUseCase
import com.alife.domain.main.create_alife.picture.repository.BaseCreateAlifePhotoRepository
import com.alife.domain.main.create_alife.picture.repository.BaseCreateAlifeRepository
import com.alife.domain.main.create_alife.video.BaseVideoStorageAlifeUseCase
import com.alife.domain.main.create_alife.video.VideoStorageAlifeUseCase
import com.alife.domain.main.create_alife.video.repository.BaseCreateAlifeVideoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface CreateAlifeViewModelModule {

    @Binds
    fun bindSaveAlifeUseCase(saveAlifeUseCase: SaveAlifeUseCase): BaseSaveAlifeUseCase

    @Binds
    fun bindVideoStorageAlifeUseCase(videoAlifeUseCase: VideoStorageAlifeUseCase): BaseVideoStorageAlifeUseCase

    @Binds
    fun bindPhotoStorageAlifeUseCase(photoAlifeUseCase: PhotoStorageAlifeUseCase): BasePhotoStorageAlifeUseCase

    @Binds
    fun bindCreateAlifePhotoRepository(repositroy: CreateAlifeRepository): BaseCreateAlifePhotoRepository

    @Binds
    fun bindCreateAlifeRepository(repository: CreateAlifeRepository): BaseCreateAlifeRepository

    @Binds
    fun bindVideoCaptureBuilderFactory(videoCaptureFactory: VideoCaptureBuilderFactory): BaseVideoCaptureBuilderFactory

    @Binds
    fun bindCreateAlifeVideoRepository(repository: CreateAlifeRepository): BaseCreateAlifeVideoRepository

    @Binds
    fun bindEntityToSaveModel(mapper: EntityToSaveModel): BaseEntityToSaveModel

    @Binds
    fun bindEntityToReadModel(mapper: EntityToReadModel): BaseEntityToReadModel
}