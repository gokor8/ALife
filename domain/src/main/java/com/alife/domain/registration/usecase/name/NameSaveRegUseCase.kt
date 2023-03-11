package com.alife.domain.registration.usecase.name

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.registration.repository.BaseRegistrationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NameSaveRegUseCase @Inject constructor(
    private val registrationRepository: BaseRegistrationRepository,
    override val dispatcher: CoroutineDispatcher,
) : AbstractUseCase(), BaseNameUseCase.Save {

    override suspend fun saveData(inputData: String) = withContext(dispatcher) {
        registrationRepository.saveRegData(
            NameSaveRegEntity(inputData)
        )
    }
}