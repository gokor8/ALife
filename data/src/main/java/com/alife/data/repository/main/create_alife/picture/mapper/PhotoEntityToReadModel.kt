package com.alife.data.repository.main.create_alife.picture.mapper

import android.content.Context
import com.alife.data.repository.main.create_alife.file_model_base.BaseReadFileModel
import com.alife.data.repository.main.create_alife.picture.model.file.BackAlifeFileName
import com.alife.data.repository.main.create_alife.file_model_base.CreateAlifePathModel
import com.alife.data.repository.main.create_alife.picture.model.file.FrontAlifeFileName
import com.alife.data.repository.main.create_alife.picture.model.image.ImageReadFileModel
import com.alife.domain.main.create_alife.picture.entity.ImageReadEntity
import com.alife.domain.core.MappingException
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PhotoEntityToReadModel @Inject constructor(
    @ApplicationContext
    private val applicationContext: Context
): BaseEntityToReadModel {

    override fun map(inputModel: ImageReadEntity): BaseReadFileModel {
        val fileName = when (inputModel) {
            is ImageReadEntity.Front -> FrontAlifeFileName()
            is ImageReadEntity.Back -> BackAlifeFileName()
            else -> throw MappingException()
        }

        return ImageReadFileModel(CreateAlifePathModel(applicationContext), fileName)
    }
}