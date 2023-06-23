package com.alife.data.repository.main.create_alife.base_mapper

import android.content.Context
import com.alife.core.mapper.Mapper
import com.alife.data.core.file_model_base.BaseFileModel
import com.alife.data.repository.main.create_alife.picture.mapper.BaseEntityToReadModel
import com.alife.data.repository.main.create_alife.video.video.Video
import com.alife.domain.core.MappingException
import com.alife.domain.main.create_alife.entity.CreateAlifeReadEntity
import com.alife.domain.main.create_alife.picture.entity.ImageReadEntity
import com.alife.domain.main.create_alife.video.entity.VideoReadEntity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface BaseCAReadEntityToFileModel : Mapper<CreateAlifeReadEntity, BaseFileModel>

class CAReadEntityToFileModel @Inject constructor(
    private val entityToReadModel: BaseEntityToReadModel,
    @ApplicationContext
    private val context: Context
) : BaseCAReadEntityToFileModel {

    override fun map(inputModel: CreateAlifeReadEntity): BaseFileModel {
        return when(inputModel) {
            is ImageReadEntity -> entityToReadModel.map(inputModel)
            is VideoReadEntity -> Video(context)
            else -> throw MappingException()
        }
    }
}