package com.alife.anotherlife.di.data.main.create_alife

import com.alife.data.repository.main.create_alife.BaseFileIsExistMapper
import com.alife.data.repository.main.create_alife.CreateAlifeRepository
import com.alife.data.repository.main.create_alife.FileIsExistMapper
import com.alife.data.repository.main.create_alife.base_mapper.BaseCAReadEntityToFileModel
import com.alife.data.repository.main.create_alife.base_mapper.BaseCAReadEntityToFilePath
import com.alife.data.repository.main.create_alife.base_mapper.CAReadEntityToFileModel
import com.alife.data.repository.main.create_alife.base_mapper.CAReadEntityToFilePath
import com.alife.domain.main.create_alife.picture.repository.BaseCreateAlifeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface CreateAlifeDataModule {

    @Binds
    fun bindCreateAlifeRepository(repository: CreateAlifeRepository): BaseCreateAlifeRepository

    @Binds
    fun bindFileIsExistMapper(mapper: FileIsExistMapper): BaseFileIsExistMapper

    @Binds
    fun bindEntityToFileWrapper(mapper: CAReadEntityToFileModel): BaseCAReadEntityToFileModel

    @Binds
    fun bindCAReadEntityToPath(mapper: CAReadEntityToFilePath): BaseCAReadEntityToFilePath
}