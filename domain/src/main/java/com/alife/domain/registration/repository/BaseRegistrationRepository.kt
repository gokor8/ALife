package com.alife.domain.registration.repository

import com.alife.domain.registration.entity.RegistrationEntity

interface BaseRegistrationRepository {

    fun saveRegData(regEntity: RegistrationEntity)
}