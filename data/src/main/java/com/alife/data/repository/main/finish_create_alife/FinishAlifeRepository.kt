package com.alife.data.repository.main.finish_create_alife

import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.finish_create_alife.mapper.BaseReadEntityToFile
import com.alife.data.repository.main.finish_create_alife.mapper.BaseReadEntityToRequestBody
import com.alife.data.repository.main.finish_create_alife.mapper.FileMediaType
import com.alife.data.services.UploadService
import com.alife.domain.main.create_alife.picture.entity.ImageReadEntity
import com.alife.domain.main.create_alife.video.entity.VideoReadEntity
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import javax.inject.Inject

class FinishAlifeRepository @Inject constructor(
    private val pathToFileMapper: Mapper<String, File>,
    private val entityToRequestBody: BaseReadEntityToRequestBody,
    private val entityToFile: BaseReadEntityToFile,
    private val uploadService: UploadService,
) : BaseFinishAlifeRepository {

    private val fileTag = "file"

    override suspend fun uploadPhoto() {
        uploadService.sendPhotos(
            mapOf(
                fileTag to entityToRequestBody.map(ImageReadEntity.Front(), FileMediaType.Image()),
                fileTag to entityToRequestBody.map(ImageReadEntity.Back(), FileMediaType.Image())
            )
        )
    }

    override suspend fun uploadVideo() {
        val videoFile = entityToRequestBody.map(VideoReadEntity(), FileMediaType.Video())

        uploadService.sendVideo(
            MultipartBody.Part.createFormData(
                fileTag,
                videoFile.name,
                RequestBody.create(FileMediaType.Video().mediaTypeParsed(), videoFile)
            )
        )
        uploadService.sendVideo(MultipartBody.Part.create(videoFile))
    }
}