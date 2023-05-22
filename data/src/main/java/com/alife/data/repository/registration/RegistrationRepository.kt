package com.alife.data.repository.registration

import com.alife.core.addons.JsonWrapper
import com.alife.data.repository.registration.mapper.BaseRegDataEntityToRequest
import com.alife.data.repository.registration.model.AuthException
import com.alife.data.repository.registration.model.CodeException
import com.alife.data.repository.registration.net_model.RequestCode
import com.alife.data.repository.registration.net_model.ResponseErrorRegistration
import com.alife.data.services.RegistrationService
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity
import com.google.gson.Gson
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val jsonWrapper: JsonWrapper,
    private val registrationService: RegistrationService,
    private val regDataEntityToRequest: BaseRegDataEntityToRequest
) : BaseRegistrationRepository {

    override suspend fun sendRegData(regDataEntity: RegDataEntity) {
        val response = registrationService.sendRegData(
            regDataEntityToRequest.map(regDataEntity)
        )

        if (!response.isSuccessful) {
            val errorResponse = jsonWrapper.fromJson(
                response.message(),
                ResponseErrorRegistration::class.java
            )

            throw AuthException(errorResponse.errorMessage)
        }
    }

    override suspend fun confirmCode(code: String) {
        val response = registrationService.sendVerificationCode(RequestCode(code))

        if (!response.isSuccessful) throw CodeException()
    }
}