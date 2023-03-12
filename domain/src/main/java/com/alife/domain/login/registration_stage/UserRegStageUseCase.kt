package com.alife.domain.login.registration_stage

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.core.usecase.AbstractSafeUseCase
import com.alife.domain.registration.core.entity.BoxRegEntity
import com.alife.domain.registration.core.entity.RegEntity
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UserRegStageUseCase @Inject constructor(
    private val stageList: ListRegStageUseCase,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<BoxRegEntity>,
) : AbstractSafeUseCase<BoxRegEntity>(dispatcher, exceptionMapper), BaseUserRegStageUseCase {

    override suspend fun getStage(): BoxRegEntity = withSafe {
        val regEntityList = stageList.map { it.readData() }

        regEntityList.firstOrNull { it.regEntity is RegEntity.Fail } ?: regEntityList.last()
    }
}