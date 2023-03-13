package com.alife.domain.login.registration_stage

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.base.entity.ReadBoxRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UserRegStageUseCaseResult @Inject constructor(
    private val stageList: ListRegStageUseCase,
    override val dispatcher: CoroutineDispatcher,
    // do need handle exceptions?
    // Are they possible(exceptions) there
) : AbstractUseCase(), BaseUserRegStageUseCase {

    override suspend fun getStage(): ReadBoxRegEntity<*> {
        val regEntityList = stageList.map { it.readAndBox() }

        return regEntityList.firstOrNull {
            it.useCaseResult is UseCaseResult.Fail
        } ?: regEntityList.last()
    }
}