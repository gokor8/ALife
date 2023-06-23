package com.alife.data.repository.main.finish_create_alife.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.create_alife.base_mapper.BaseCAReadEntityToFileModel
import com.alife.domain.main.create_alife.entity.CreateAlifeReadEntity
import java.io.File
import javax.inject.Inject

interface BaseReadEntityToFile : Mapper<CreateAlifeReadEntity, File>

class ReadEntityToFile @Inject constructor(
    private val caReadEntityToFileModel: BaseCAReadEntityToFileModel,
    private val fileIsExistMapper: BaseFileIsExistMapper
) : BaseReadEntityToFile {

    override fun map(inputModel: CreateAlifeReadEntity): File {
        return fileIsExistMapper.map(
            File(caReadEntityToFileModel.map(inputModel).getFullPath())
        )
    }
}