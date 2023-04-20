package com.alife.domain.main.create_alife

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.AbstractSafeUseCaseResult
import com.alife.domain.main.create_alife.entity.SaveImageEntity
import com.alife.domain.main.create_alife.repository.BaseCreateAlifeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveAlifeUseCase @Inject constructor(
    private val createAlifeRepository: BaseCreateAlifeRepository,
    dispatcher: CoroutineDispatcher,
    throwableUCMapper: ThrowableUCMapper<Unit>
) : AbstractSafeUseCaseResult<Unit>(dispatcher, throwableUCMapper), BaseSaveAlifeUseCase {

    override suspend fun saveImage(saveImageEntity: SaveImageEntity) = withContext(Dispatchers.IO) {
        createAlifeRepository.saveToFile(saveImageEntity)
    }
}