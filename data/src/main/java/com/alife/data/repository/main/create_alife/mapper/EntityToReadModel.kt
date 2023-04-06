package com.alife.data.repository.main.create_alife.mapper

import com.alife.data.repository.main.create_alife.model.base.BaseReadFileModel
import com.alife.data.repository.main.create_alife.model.file.BackAlifeFileName
import com.alife.data.repository.main.create_alife.model.file.CreateAlifePathModel
import com.alife.data.repository.main.create_alife.model.file.FrontAlifeFileName
import com.alife.data.repository.main.create_alife.model.image.ImageReadFileModel
import com.alife.data.repository.main.create_alife.model.image.JpegExtension
import com.alife.domain.main.create_alife.entity.ReadImageEntity
import com.alife.domain.core.MappingException
import javax.inject.Inject

class EntityToReadModel @Inject constructor(): BaseEntityToReadModel {

    override fun map(inputModel: ReadImageEntity): BaseReadFileModel {
        val fileName = when (inputModel) {
            is ReadImageEntity.FrontReadImageEntity -> FrontAlifeFileName()
            is ReadImageEntity.BackReadImageEntity -> BackAlifeFileName()
            else -> throw MappingException()
        }

        return ImageReadFileModel(fileName)
    }
}