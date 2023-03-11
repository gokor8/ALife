package com.alife.domain.registration.usecase.base

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.registration.core.entity.BoxerRegEntity
import com.alife.domain.registration.repository.BaseRegistrationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class RegistrationSaveUseCaseBase<M : BoxerRegEntity>(
    private val registrationRepository: BaseRegistrationRepository,
    override val dispatcher: CoroutineDispatcher
) : AbstractUseCase(), BaseBaseRegUseCase.Save<M> {

    abstract fun getSaveModel(inputData: String): SaveRegInputEntity<*>

    override suspend fun saveData(inputData: String) = withContext(dispatcher) {
        registrationRepository.saveRegData(
            getSaveModel(inputData)
        )
    }
}