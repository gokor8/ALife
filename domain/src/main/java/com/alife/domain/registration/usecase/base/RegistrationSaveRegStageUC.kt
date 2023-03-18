package com.alife.domain.registration.usecase.base

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.entity.SaveRegInputEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class RegistrationSaveRegStageUC<M>(
    private val registrationRepository: BaseRegistrationRepository,
    override val dispatcher: CoroutineDispatcher
) : AbstractUseCase(), BaseRegStageUseCase.Save<M> {

    abstract fun getSaveModel(inputData: String): SaveRegInputEntity<*>

    override suspend fun saveData(inputData: String) = withContext(dispatcher) {
        registrationRepository.saveRegData(
            getSaveModel(inputData)
        )
    }
}