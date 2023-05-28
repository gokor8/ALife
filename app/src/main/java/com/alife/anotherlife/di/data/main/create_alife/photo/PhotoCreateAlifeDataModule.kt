package com.alife.anotherlife.di.data.main.create_alife.photo

import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.BasePhotoFinishExceptionMapper
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper.PhotoFinishExceptionMapper
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.mapper.BasePhotoPathEntityToUIPictures
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.mapper.PhotoPathEntityToUIPictures
import com.alife.data.repository.main.create_alife.CreateAlifeRepository
import com.alife.data.repository.main.create_alife.base_mapper.BaseCAReadEntityToFileModel
import com.alife.data.repository.main.create_alife.base_mapper.BaseCAReadEntityToFilePath
import com.alife.data.repository.main.create_alife.picture.mapper.BaseEntityToReadModel
import com.alife.data.repository.main.create_alife.picture.mapper.BaseEntityToSaveModel
import com.alife.data.repository.main.create_alife.base_mapper.CAReadEntityToFileModel
import com.alife.data.repository.main.create_alife.base_mapper.CAReadEntityToFilePath
import com.alife.data.repository.main.create_alife.picture.mapper.PhotoEntityToReadModel
import com.alife.data.repository.main.create_alife.picture.mapper.PhotoEntityToSaveModel
import com.alife.domain.main.create_alife.picture.BasePhotoStorageAlifeUseCase
import com.alife.domain.main.create_alife.picture.BaseSaveAlifeUseCase
import com.alife.domain.main.create_alife.picture.PhotoStorageAlifeUseCase
import com.alife.domain.main.create_alife.picture.SaveImageAlifeUseCase
import com.alife.domain.main.create_alife.picture.repository.BaseCreateAlifePhotoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface PhotoCreateAlifeDataModule {

    @Binds
    fun bindSaveAlifeUseCase(saveImageAlifeUseCase: SaveImageAlifeUseCase): BaseSaveAlifeUseCase

    @Binds
    fun bindPhotoStorageAlifeUseCase(photoAlifeUseCase: PhotoStorageAlifeUseCase): BasePhotoStorageAlifeUseCase

    @Binds
    fun bindPhotoPathEntityToUIPictures(mapper: PhotoPathEntityToUIPictures): BasePhotoPathEntityToUIPictures

    @Binds
    fun bindPhotoFinishExceptionMapper(mapper: PhotoFinishExceptionMapper): BasePhotoFinishExceptionMapper

    @Binds
    fun bindCreateAlifePhotoRepository(repositroy: CreateAlifeRepository): BaseCreateAlifePhotoRepository

    @Binds
    fun bindEntityToSaveModel(mapper: PhotoEntityToSaveModel): BaseEntityToSaveModel

    @Binds
    fun bindEntityToReadModel(mapper: PhotoEntityToReadModel): BaseEntityToReadModel
}