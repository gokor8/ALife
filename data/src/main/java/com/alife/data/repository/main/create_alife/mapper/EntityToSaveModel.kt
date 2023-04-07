package com.alife.data.repository.main.create_alife.mapper

import com.alife.data.data_source.cache.file.OriginalFileWrapper
import com.alife.data.data_source.cache.file.OriginalFileWrapperFactory
import com.alife.data.repository.main.create_alife.model.base.BaseSaveFileModel
import com.alife.data.repository.main.create_alife.model.file.BackAlifeFileName
import com.alife.data.repository.main.create_alife.model.file.FrontAlifeFileName
import com.alife.data.repository.main.create_alife.model.image.ImageSaveFileModel
import com.alife.domain.main.create_alife.entity.SaveImageEntity
import javax.inject.Inject

class EntityToSaveModel @Inject constructor(): BaseEntityToSaveModel {

    override fun map(inputModel: SaveImageEntity): BaseSaveFileModel {
        val fileName = when(inputModel) {
            is SaveImageEntity.FrontSaveImageEntity -> FrontAlifeFileName()
            is SaveImageEntity.BackSaveImageEntity -> BackAlifeFileName()
            else -> onElse()
        }

        return ImageSaveFileModel(inputModel.byteArray, fileName, OriginalFileWrapperFactory())
    }
}