package com.alife.domain.registration.usecase.username

import com.alife.domain.registration.repository.BaseRegistrationRepository
import javax.inject.Inject

class UsernameUseCase @Inject constructor(
    private val registrationRepository: BaseRegistrationRepository,
) {

    fun saveData(inputData: String) {
        registrationRepository.saveRegData(
            UsernameRegistrationEntity(inputData)
        )
    }
}