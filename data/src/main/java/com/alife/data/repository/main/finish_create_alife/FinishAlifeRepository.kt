package com.alife.data.repository.main.finish_create_alife

import com.alife.data.repository.main.finish_create_alife.mapper.BaseReadEntityToRequestBody
import com.alife.data.repository.main.finish_create_alife.mapper.FileMediaType
import com.alife.data.services.UploadService
import com.alife.domain.main.create_alife.picture.entity.ImageReadEntity
import com.alife.domain.main.create_alife.video.entity.VideoReadEntity
import com.alife.domain.main.finish_create_alife.BaseFinishAlifeRepository
import com.alife.domain.main.finish_create_alife.BaseLocationEntity
import com.alife.domain.main.finish_create_alife.LocationEntity
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class FinishAlifeRepository @Inject constructor(
    private val entityToRequestBody: BaseReadEntityToRequestBody,
    private val uploadService: UploadService,
) : BaseFinishAlifeRepository {

    override suspend fun uploadPhoto(locationEntity: BaseLocationEntity) {
        val firstPicture = entityToRequestBody.map(ImageReadEntity.Front(), FileMediaType.Image())
        val secondPicture = entityToRequestBody.map(ImageReadEntity.Back(), FileMediaType.Image())

        if (locationEntity is LocationEntity) with(locationEntity) {
            uploadService.sendPhotos(latitude, longitude, firstPicture, secondPicture)
        }
        else {
            uploadService.sendPhotos(firstPicture, secondPicture)
        }
    }

    override suspend fun uploadVideo(locationEntity: BaseLocationEntity) {
        val videoFile = entityToRequestBody.map(VideoReadEntity(), FileMediaType.Video())

        if (locationEntity is LocationEntity)
            uploadService.sendVideo(locationEntity.latitude, locationEntity.longitude, videoFile)
        else
            uploadService.sendVideo(videoFile)
    }
}