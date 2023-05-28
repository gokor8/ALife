package com.alife.data.repository.main.create_alife

import com.alife.data.repository.main.create_alife.base_mapper.BaseCAReadEntityToFilePath
import com.alife.data.repository.main.create_alife.picture.mapper.BaseEntityToReadModel
import com.alife.data.repository.main.create_alife.picture.mapper.BaseEntityToSaveModel
import com.alife.data.repository.main.finish_create_alife.mapper.BaseFileIsExistMapper
import com.alife.domain.main.create_alife.picture.entity.PhotoPathEntity
import com.alife.domain.main.create_alife.picture.entity.ImageReadEntity
import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity
import com.alife.domain.main.create_alife.picture.repository.BaseCreateAlifePhotoRepository
import com.alife.domain.main.create_alife.picture.repository.BaseCreateAlifeRepository
import com.alife.domain.main.create_alife.video.entity.VideoReadEntity
import com.alife.domain.main.create_alife.video.entity.VideoPathEntity
import com.alife.domain.main.create_alife.video.repository.BaseCreateAlifeVideoRepository
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import javax.inject.Inject

class CreateAlifeRepository @Inject constructor(
    private val entityToSaveModel: BaseEntityToSaveModel,
    private val entityToReadModel: BaseEntityToReadModel,
    private val caReadEntityToPath: BaseCAReadEntityToFilePath,
    private val pathIsExistMapper: BasePathIsExistMapper,
) : BaseCreateAlifeRepository, BaseCreateAlifePhotoRepository, BaseCreateAlifeVideoRepository {

    override suspend fun saveToFile(saveImageEntity: SaveImageEntity) {
        val saveModel = entityToSaveModel.map(saveImageEntity)

        val out = FileOutputStream(saveModel.createFile())
        saveModel.writeToFile(out)
        out.flush()
        out.close()
    }

    override suspend fun readFromFile(imageReadEntity: ImageReadEntity): ByteArray {
        val readModel = entityToReadModel.map(imageReadEntity)

        val file = File(readModel.getFullPath())

        val imageByteArray = ByteArray(file.length().toInt())

        val buf = BufferedInputStream(FileInputStream(file))
        buf.read(imageByteArray, 0, imageByteArray.size)
        buf.close()

        return imageByteArray
    }

    override suspend fun readPhotoUrls(): PhotoPathEntity {
        val frontPath = caReadEntityToPath.map(ImageReadEntity.Front())
        val backPath = caReadEntityToPath.map(ImageReadEntity.Back())

        return PhotoPathEntity(pathIsExistMapper.map(frontPath), pathIsExistMapper.map(backPath))
    }

    override fun getVideoUrl(): VideoPathEntity {
        return VideoPathEntity(
            pathIsExistMapper.map(caReadEntityToPath.map(VideoReadEntity()))
        )
    }
}