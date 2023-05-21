package com.alife.domain.registration.usecase.base

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.registration.repository.BaseRegCacheRepository
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity
import com.alife.domain.registration.usecase.base.entity.SaveCacheInputEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class RegistrationSaveRegStageUC<M>(
    private val registrationRepository: BaseRegCacheRepository,
    override val dispatcher: CoroutineDispatcher
) : AbstractUseCase(), BaseRegStageUseCase.Save<M> {

    abstract fun getSaveModel(inputData: String): RegCacheInputEntity.Save<*>

    override suspend fun saveData(inputData: String) = withContext(dispatcher) {
        registrationRepository.saveData(getSaveModel(inputData))
    }
}