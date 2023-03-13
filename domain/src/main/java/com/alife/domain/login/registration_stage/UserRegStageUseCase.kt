package com.alife.domain.login.registration_stage

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.AbstractSafeUseCase
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.core.entity.BoxRegEntity
import com.alife.domain.registration.core.entity.RegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UserRegStageUseCase @Inject constructor(
    private val stageList: ListRegStageUseCase,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableUCMapper<UseCaseResult.EmptySuccess>,
) : AbstractSafeUseCase<UseCaseResult.EmptySuccess>(dispatcher, exceptionMapper),
    BaseUserRegStageUseCase {

    override suspend fun getStage() = withSafe {
        val regEntityList = stageList.map { it.readData() }

        regEntityList.firstOrNull { it is UseCaseResult.Fail } ?: regEntityList.last()
    }
}