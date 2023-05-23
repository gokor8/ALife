package com.alife.data.repository.registration

import com.alife.core.addons.JsonWrapper
import com.alife.core.mapper.Mapper
import com.alife.data.core.GenericException
import com.alife.data.interceptor.model.TokensModel
import com.alife.data.repository.registration.mapper.BaseRegDataEntityToRequest
import com.alife.data.repository.registration.model.AuthException
import com.alife.data.repository.registration.model.CodeException
import com.alife.data.repository.registration.net_model.RequestCode
import com.alife.data.repository.registration.net_model.ResponseErrorRegistration
import com.alife.data.services.RegistrationService
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity
import com.alife.domain.registration.usecase.token.TokenStateEntity
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val jsonWrapper: JsonWrapper,
    private val registrationService: RegistrationService,
    private val regDataEntityToRequest: BaseRegDataEntityToRequest,
    private val tokensMapper: Mapper<TokensModel, TokenStateEntity.Fill>
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

    override suspend fun confirmCode(email: String, code: String): TokenStateEntity.Fill {
        val response = registrationService.sendVerificationCode(RequestCode(email, code))

        // TODO инкапсулировать в классы и сделать ООПшно
        return when(response.code()) {
            200 -> response.body()?.let { tokensMapper.map(it) } ?: throw GenericException()
            400 -> throw CodeException()
            else -> throw GenericException()
        }
    }
}