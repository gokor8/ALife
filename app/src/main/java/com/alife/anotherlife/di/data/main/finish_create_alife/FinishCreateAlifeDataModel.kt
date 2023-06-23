package com.alife.anotherlife.di.data.main.finish_create_alife

import com.alife.domain.main.finish_create_alife.BaseFinishAlifeRepository
import com.alife.data.repository.main.finish_create_alife.FinishAlifeRepository
import com.alife.data.repository.main.finish_create_alife.mapper.BaseFileToMultipart
import com.alife.data.repository.main.finish_create_alife.mapper.BaseReadEntityToFile
import com.alife.data.repository.main.finish_create_alife.mapper.BaseReadEntityToRequestBody
import com.alife.data.repository.main.finish_create_alife.mapper.FileToMultipart
import com.alife.data.repository.main.finish_create_alife.mapper.ReadEntityToFile
import com.alife.data.repository.main.finish_create_alife.mapper.ReadEntityToRequestBody
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface FinishCreateAlifeDataModel {

    @Binds
    fun bindFinishAlifeRepository(repository: FinishAlifeRepository): BaseFinishAlifeRepository

    @Binds
    fun bindReadEntityToRequestBody(mapper: ReadEntityToRequestBody): BaseReadEntityToRequestBody

    @Binds
    fun bindFileToMultipart(mapper: FileToMultipart): BaseFileToMultipart

    @Binds
    fun bindReadEntityToFile(mapper: ReadEntityToFile): BaseReadEntityToFile
}