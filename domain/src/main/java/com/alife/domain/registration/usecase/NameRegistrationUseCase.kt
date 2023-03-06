package com.alife.domain.registration.usecase

import com.alife.domain.registration.repository.BaseRegistrationRepository
import javax.inject.Inject

class NameRegistrationUseCase @Inject constructor(
    private val registrationRepository: BaseRegistrationRepository,
) {

    fun saveData(inputData: String) {
        registrationRepository.saveRegData(
            NameRegistrationEntity(inputData)
        )
    }
}