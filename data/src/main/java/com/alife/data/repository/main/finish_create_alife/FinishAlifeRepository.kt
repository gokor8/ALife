package com.alife.data.repository.main.finish_create_alife

import com.alife.data.repository.main.finish_create_alife.mapper.BaseReadEntityToRequestBody
import com.alife.data.repository.main.finish_create_alife.mapper.FileMediaType
import com.alife.data.services.UploadService
import com.alife.domain.main.create_alife.picture.entity.ImageReadEntity
import com.alife.domain.main.create_alife.video.entity.VideoReadEntity
import com.alife.domain.main.finish_create_alife.BaseFinishAlifeRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class FinishAlifeRepository @Inject constructor(
    private val entityToRequestBody: BaseReadEntityToRequestBody,
    private val uploadService: UploadService,
) : BaseFinishAlifeRepository {

    private val fileTag = "file"

    override suspend fun uploadPhoto() {
        uploadService.sendPhotos(
            entityToRequestBody.map(ImageReadEntity.Front(), FileMediaType.Image()),
            entityToRequestBody.map(ImageReadEntity.Back(), FileMediaType.Image())
        )
    }

    override suspend fun uploadVideo() {
        val videoFile = entityToRequestBody.map(VideoReadEntity(), FileMediaType.Video())

        uploadService.sendVideo(videoFile)
    }
}