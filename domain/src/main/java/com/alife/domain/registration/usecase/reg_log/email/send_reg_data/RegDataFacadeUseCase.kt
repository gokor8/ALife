package com.alife.domain.registration.usecase.reg_log.email.send_reg_data

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.registration.usecase.reg_log.birthday.BaseBirthdayUseCase
import com.alife.domain.registration.usecase.reg_log.email.save_read.BaseEmailUseCase
import com.alife.domain.registration.usecase.reg_log.email.send_reg_data.entity.RegDataEntity
import com.alife.domain.registration.usecase.reg_log.email.send_reg_data.mapper.UCResultToEntityMapper
import com.alife.domain.registration.usecase.reg_log.name.BaseNameUseCase
import com.alife.domain.registration.usecase.reg_log.username.BaseUsernameUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class RegDataFacadeUseCase @Inject constructor(
    override val dispatcher: CoroutineDispatcher,
    private val useCaseResultToEntityMapper: UCResultToEntityMapper,
    private val nameReadRegStageUseCase: BaseNameUseCase.Read,
    private val usernameReadRegStageUseCase: BaseUsernameUseCase.Read,
    private val birthdayReadRegStageUseCase: BaseBirthdayUseCase.Read,
    private val emailReadRegStageUseCase: BaseEmailUseCase.Read,
) : AbstractUseCase(), BaseRegDataFacadeUseCase {

    override suspend fun fillRegData(): RegDataEntity {
        return RegDataEntity(
            useCaseResultToEntityMapper.map(nameReadRegStageUseCase.readData()).name,
            useCaseResultToEntityMapper.map(usernameReadRegStageUseCase.readData()).username,
            useCaseResultToEntityMapper.map(birthdayReadRegStageUseCase.readData()).birthday,
            useCaseResultToEntityMapper.map(emailReadRegStageUseCase.readData()).email,
        )
    }
}