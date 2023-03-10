package com.alife.domain.registration.usecase.name

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.registration.repository.BaseRegistrationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NameReadRegUseCase@Inject constructor(
    private val registrationRepository: BaseRegistrationRepository,
    override val dispatcher: CoroutineDispatcher,
) : AbstractUseCase() {

    suspend fun readName() = withContext(dispatcher) {
        registrationRepository.saveRegData(NameReadRegEntity())
    }
}