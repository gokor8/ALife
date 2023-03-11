package com.alife.domain.registration.usecase.birthday

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.name.NameSaveRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BirthdaySaveRegUseCase @Inject constructor(
    private val registrationRepository: BaseRegistrationRepository,
    override val dispatcher: CoroutineDispatcher,
) : AbstractUseCase(), BaseBirthdayUseCase.Save {

    override suspend fun saveData(inputData: String) = withContext(dispatcher) {
        registrationRepository.saveRegData(
            NameSaveRegEntity(inputData)
        )
    }
}