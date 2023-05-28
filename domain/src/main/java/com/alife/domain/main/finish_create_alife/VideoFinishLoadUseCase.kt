package com.alife.domain.main.finish_create_alife

import javax.inject.Inject

interface BaseVideoFinishLoadUseCase : BaseFinishLoadUseCase

class VideoFinishLoadUseCase @Inject constructor(
    finishAlifeRepository: BaseFinishAlifeRepository
) : BaseFinishLoadUseCase.Abstract(finishAlifeRepository), BaseVideoFinishLoadUseCase {

    override suspend fun upload() {
        repository.uploadVideo()
    }
}