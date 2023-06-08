package com.alife.anotherlife.di.data.main.create_alife

import com.alife.data.core.file_model_base.mapper.BasePathIsExistMapper
import com.alife.data.repository.main.create_alife.CreateAlifeRepository
import com.alife.data.core.file_model_base.mapper.PathFileIsExistMapper
import com.alife.data.repository.main.create_alife.base_mapper.BaseCAReadEntityToFileModel
import com.alife.data.repository.main.create_alife.base_mapper.BaseCAReadEntityToFilePath
import com.alife.data.repository.main.create_alife.base_mapper.CAReadEntityToFileModel
import com.alife.data.repository.main.create_alife.base_mapper.CAReadEntityToFilePath
import com.alife.data.repository.main.finish_create_alife.mapper.BaseFileIsExistMapper
import com.alife.data.repository.main.finish_create_alife.mapper.FileIsExistMapper
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
    fun bindPathIsExistMapper(mapper: PathFileIsExistMapper): BasePathIsExistMapper

    @Binds
    fun bindFileIsExistMapper(mapper: FileIsExistMapper): BaseFileIsExistMapper

    @Binds
    fun bindEntityToFileWrapper(mapper: CAReadEntityToFileModel): BaseCAReadEntityToFileModel

    @Binds
    fun bindCAReadEntityToPath(mapper: CAReadEntityToFilePath): BaseCAReadEntityToFilePath
}