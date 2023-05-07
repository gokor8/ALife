package com.alife.data.repository.main.create_alife

import com.alife.data.repository.main.create_alife.picture.mapper.BaseEntityToReadModel
import com.alife.data.repository.main.create_alife.picture.mapper.BaseEntityToSaveModel
import com.alife.data.repository.main.create_alife.file_model_base.BaseReadFileModel
import com.alife.data.repository.main.create_alife.file_model_base.BaseSaveFileModel
import com.alife.domain.main.create_alife.picture.entity.ReadImageEntity
import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity

class FakeEntityToSaveModel : BaseEntityToSaveModel {
    override fun map(inputModel: SaveImageEntity): BaseSaveFileModel {
        TODO("Not yet implemented")
    }
}

class FakeEntityToReadModel : BaseEntityToReadModel {
    override fun map(inputModel: ReadImageEntity): BaseReadFileModel {
        TODO("Not yet implemented")
    }
}