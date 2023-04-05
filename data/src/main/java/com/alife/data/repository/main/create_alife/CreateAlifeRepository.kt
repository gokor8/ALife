package com.alife.data.repository.main.create_alife

import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.create_alife.model.base.BaseFileModel
import com.alife.domain.main.create_alife.entity.SaveImageEntity
import com.alife.domain.main.create_alife.repository.BaseCreateAlifeRepository
import java.io.FileOutputStream
import javax.inject.Inject


class CreateAlifeRepository @Inject constructor(
    private val entityToSaveModel: Mapper<SaveImageEntity, BaseFileModel>
) : BaseCreateAlifeRepository {

    override suspend fun saveToFile(saveImageEntity: SaveImageEntity) {
        val saveModel = entityToSaveModel.map(saveImageEntity)

        val out = FileOutputStream(saveModel.createFile())
        saveModel.writeToFile(out)//.compress(Bitmap.CompressFormat.JPEG, 90, out)
        out.flush()
        out.close()
    }
}