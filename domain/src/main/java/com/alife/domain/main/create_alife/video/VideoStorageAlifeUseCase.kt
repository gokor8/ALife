package com.alife.domain.main.create_alife.video

import com.alife.domain.main.create_alife.video.entity.VideoPathEntity
import com.alife.domain.main.create_alife.video.repository.BaseCreateAlifeVideoRepository
import javax.inject.Inject

class VideoStorageAlifeUseCase @Inject constructor(
    private val repository: BaseCreateAlifeVideoRepository
) : BaseVideoStorageAlifeUseCase {

    override fun getVideoStorageEntity() = repository.getVideoUrl()

    override fun getVideoRawPathEntity() = repository.getRawVideoUrl()
}