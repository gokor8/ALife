package com.alife.data.repository.main.create_alife.base_mapper

import com.alife.core.mapper.Mapper
import com.alife.domain.main.create_alife.entity.CreateAlifeReadEntity
import javax.inject.Inject

interface BaseCAReadEntityToFilePath : Mapper<CreateAlifeReadEntity, String>

class CAReadEntityToFilePath @Inject constructor(
    private val caReadEntityToPath: BaseCAReadEntityToFileModel
) : BaseCAReadEntityToFilePath {

    override fun map(inputModel: CreateAlifeReadEntity) =
        caReadEntityToPath.map(inputModel).getFullPath()
}