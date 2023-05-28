package com.alife.domain.main.finish_create_alife

import javax.inject.Inject

interface BasePhotoFinishLoadUseCase : BaseFinishLoadUseCase

class PhotoFinishLoadUseCase @Inject constructor(
    finishAlifeRepository: BaseFinishAlifeRepository
) : BaseFinishLoadUseCase.Abstract(finishAlifeRepository), BasePhotoFinishLoadUseCase {

    override suspend fun upload() {
        repository.uploadPhoto()
    }
}