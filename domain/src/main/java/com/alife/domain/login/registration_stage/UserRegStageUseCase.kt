package com.alife.domain.login.registration_stage

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.core.usecase.AbstractSafeUseCase
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase
import kotlinx.coroutines.CoroutineDispatcher

class UserRegStageUseCase(
    private val stageList: List<BaseRegStageUseCase>,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<RegStageEntity>
) : AbstractSafeUseCase<RegStageEntity>(dispatcher, exceptionMapper) {

    fun getStage(): RegStageEntity {
        stageList.
    }
}