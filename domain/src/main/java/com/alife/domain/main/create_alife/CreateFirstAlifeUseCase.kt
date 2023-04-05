package com.alife.domain.main.create_alife

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.AbstractSafeUseCaseResult
import com.alife.domain.main.create_alife.entity.SaveImageEntity
import com.alife.domain.main.create_alife.repository.BaseCreateAlifeRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class CreateFirstAlifeUseCase @Inject constructor(
    private val createAlifeRepository: BaseCreateAlifeRepository,
    dispatcher: CoroutineDispatcher,
    throwableUCMapper: ThrowableUCMapper<Unit>
) : AbstractSafeUseCaseResult<Unit>(dispatcher, throwableUCMapper) {

    suspend fun saveImage(saveImageEntity: SaveImageEntity) = withSafe {
        createAlifeRepository.saveToFile(saveImageEntity)
    }
}