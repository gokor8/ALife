package com.alife.data.repository.main.create_alife

import android.content.Context
import com.alife.core.mapper.Mapper
import com.alife.data.data_source.cache.file.OriginalFileWrapper
import com.alife.data.repository.main.create_alife.picture.mapper.BaseEntityToFileWrapper
import com.alife.data.repository.main.create_alife.picture.mapper.BaseEntityToReadModel
import com.alife.data.repository.main.create_alife.picture.mapper.BaseEntityToSaveModel
import com.alife.data.repository.main.create_alife.picture.model.file.BackAlifeFileName
import com.alife.data.repository.main.create_alife.picture.model.file.FrontAlifeFileName
import com.alife.data.repository.main.create_alife.video.entity.VideoStorageEntity
import com.alife.data.repository.main.create_alife.video.video.VideoFileModel
import com.alife.domain.main.create_alife.picture.entity.PhotoPathEntity
import com.alife.domain.main.create_alife.picture.entity.ReadImageEntity
import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity
import com.alife.domain.main.create_alife.picture.repository.BaseCreateAlifePhotoRepository
import com.alife.domain.main.create_alife.picture.repository.BaseCreateAlifeRepository
import com.alife.domain.main.create_alife.video.entity.BaseVideoStorageEntity
import com.alife.domain.main.create_alife.video.repository.BaseCreateAlifeVideoRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import javax.inject.Inject

class CreateAlifeRepository @Inject constructor(
    private val entityToSaveModel: BaseEntityToSaveModel,
    private val entityToReadModel: BaseEntityToReadModel,
    private val entityToFileWrapper: BaseEntityToFileWrapper,
    @ApplicationContext
    private val context: Context
) : BaseCreateAlifeRepository, BaseCreateAlifePhotoRepository, BaseCreateAlifeVideoRepository {

    override suspend fun saveToFile(saveImageEntity: SaveImageEntity) {
        val saveModel = entityToSaveModel.map(saveImageEntity)

        val out = FileOutputStream(saveModel.createFile())
        saveModel.writeToFile(out)
        out.flush()
        out.close()
    }

    override suspend fun readFromFile(readImageEntity: ReadImageEntity): ByteArray {
        val readModel = entityToReadModel.map(readImageEntity)

        val file = File(readModel.getFullFilePath())

        val imageByteArray = ByteArray(file.length().toInt())

        val buf = BufferedInputStream(FileInputStream(file))
        buf.read(imageByteArray, 0, imageByteArray.size)
        buf.close()

        return imageByteArray
    }

    override suspend fun readPhotoUrls(): PhotoPathEntity {
        val frontImageModel = entityToFileWrapper.map(ReadImageEntity.FrontReadImageEntity())
        val backImageModel = entityToFileWrapper.map(ReadImageEntity.BackReadImageEntity())

        return if (frontImageModel.exists() && backImageModel.exists())
            PhotoPathEntity(frontImageModel.path, backImageModel.path)
        else
            throw NoFileException()
    }

    override fun getVideoStorageModel() = VideoStorageEntity(
        File(VideoFileModel(context).getFullFilePath())
    )
}