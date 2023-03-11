package com.alife.domain.registration.usecase.username

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.registration.repository.BaseRegistrationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsernameSaveUseCase @Inject constructor(
    private val registrationRepository: BaseRegistrationRepository,
    override val dispatcher: CoroutineDispatcher,
) : AbstractUseCase(), BaseUsernameUseCase.Save {

    override suspend fun saveData(inputData: String) = withContext(dispatcher) {
        registrationRepository.saveRegData(
            UsernameSaveRegEntity(inputData)
        )
    }
}