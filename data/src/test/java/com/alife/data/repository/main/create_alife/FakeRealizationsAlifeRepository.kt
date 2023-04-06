package com.alife.data.repository.main.create_alife

import com.alife.data.repository.main.create_alife.mapper.BaseEntityToReadModel
import com.alife.data.repository.main.create_alife.mapper.BaseEntityToSaveModel
import com.alife.data.repository.main.create_alife.model.base.BaseReadFileModel
import com.alife.data.repository.main.create_alife.model.base.BaseSaveFileModel
import com.alife.domain.main.create_alife.entity.ReadImageEntity
import com.alife.domain.main.create_alife.entity.SaveImageEntity

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