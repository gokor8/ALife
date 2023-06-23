package com.alife.domain.main.create_alife.picture

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.AbstractSafeUseCaseResult
import com.alife.domain.main.create_alife.picture.entity.ImageReadEntity
import com.alife.domain.main.create_alife.picture.repository.BaseCreateAlifeRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ReadAlifeUseCase @Inject constructor(
    private val createAlifeRepository: BaseCreateAlifeRepository,
    dispatcher: CoroutineDispatcher,
    throwableUCMapper: ThrowableUCMapper<ByteArray>
) : AbstractSafeUseCaseResult<ByteArray>(dispatcher, throwableUCMapper) {

    suspend fun readImage(imageReadEntity: ImageReadEntity) = withSafe {
        createAlifeRepository.readFromFile(imageReadEntity)
    }
}