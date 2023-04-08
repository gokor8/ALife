package com.alife.domain.main.create_alife

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.AbstractSafeUseCaseResult
import com.alife.domain.main.create_alife.entity.ReadImageEntity
import com.alife.domain.main.create_alife.repository.BaseCreateAlifeRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ReadAlifeUseCase @Inject constructor(
    private val createAlifeRepository: BaseCreateAlifeRepository,
    dispatcher: CoroutineDispatcher,
    throwableUCMapper: ThrowableUCMapper<ByteArray>
) : AbstractSafeUseCaseResult<ByteArray>(dispatcher, throwableUCMapper) {

    suspend fun readImage(readImageEntity: ReadImageEntity) = withSafe {
        createAlifeRepository.readFromFile(readImageEntity)
    }
}