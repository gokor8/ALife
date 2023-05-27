package com.alife.data.repository.main.create_alife.picture.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.data_source.cache.file.OriginalFileWrapper
import com.alife.domain.main.create_alife.picture.entity.ReadImageEntity
import javax.inject.Inject

interface BaseEntityToFileWrapper : Mapper<ReadImageEntity, OriginalFileWrapper>

class EntityToFileWrapper @Inject constructor(
    private val mapper: BaseEntityToReadModel
) : BaseEntityToFileWrapper {
    override fun map(inputModel: ReadImageEntity): OriginalFileWrapper {
        return OriginalFileWrapper(mapper.map(inputModel).getFullFilePath())
    }
}