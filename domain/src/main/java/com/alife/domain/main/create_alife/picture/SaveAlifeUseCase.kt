package com.alife.domain.main.create_alife.picture

import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity
import com.alife.domain.main.create_alife.picture.repository.BaseCreateAlifeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveAlifeUseCase @Inject constructor(
    private val createAlifeRepository: BaseCreateAlifeRepository,
    private val dispatcher: CoroutineDispatcher,
) : BaseSaveAlifeUseCase {

    override suspend fun saveImage(saveImageEntity: SaveImageEntity) = withContext(dispatcher) {
        createAlifeRepository.saveToFile(saveImageEntity)
    }
}