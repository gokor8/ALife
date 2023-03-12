package com.alife.domain.registration.usecase.email

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.core.usecase.AbstractSafeUseCase
import com.alife.domain.registration.core.addons.EmptyException
import com.alife.domain.registration.core.entity.BoxRegEntity
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.birthday.BaseBirthdayUseCase
import com.alife.domain.registration.usecase.email.save_read.BaseEmailUseCase
import com.alife.domain.registration.usecase.name.BaseNameUseCase
import com.alife.domain.registration.usecase.username.BaseUsernameUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SendRegDataUseCase @Inject constructor(
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<RegDataState>,
    private val registrationRepository: BaseRegistrationRepository,
    private val nameReadRegStageUseCase: BaseNameUseCase.Read,
    private val usernameReadRegStageUseCase: BaseUsernameUseCase.Read,
    private val birthdayReadRegStageUseCase: BaseBirthdayUseCase.Read,
    private val emailReadRegStageUseCase: BaseEmailUseCase.Read,
) : AbstractSafeUseCase<RegDataState>(dispatcher, exceptionMapper), BaseSendRegDataUseCase {

    override suspend fun sendRegData(): RegDataState {
        // Repository
        return registrationRepository.sendRegData(
            RegDataEntity(
                checkData(nameReadRegStageUseCase.readData()).result,
                checkData(usernameReadRegStageUseCase.readData()).result,
                checkData(birthdayReadRegStageUseCase.readData()).result,
                checkData(emailReadRegStageUseCase.readData()).result,
            )
        )
    }

    private fun checkData(regEntity: BoxRegEntity): DefaultRegEntity.Success {
        return (regEntity.regEntity as? DefaultRegEntity.Success) ?: throw EmptyException()
    }
}